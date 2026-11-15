#include <jni.h>
#include <string>
#include <cmath>

extern "C" JNIEXPORT jboolean JNICALL
Java_com_mnmaman_spacejet_engine_PhysicsEngine_nativeValidateDesign(
        JNIEnv *env,
        jobject,
        jfloat totalMass,
        jfloat fuelAmount,
        jfloat availablePower,
        jfloat budget) {

    const float maxAllowedMass = 5000.0f;
    const float minRequiredPower = 150.0f;

    if (totalMass <= maxAllowedMass && availablePower >= minRequiredPower && budget >= 0.0f) {
        return JNI_TRUE;
    }
    return JNI_FALSE;
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_mnmaman_spacejet_engine_PhysicsEngine_nativeCalculateTelemetry(
        JNIEnv *env,
        jobject,
        jfloat totalMass,
        jfloat fuelAmount,
        jfloat availablePower,
        jfloat budget) {

    float wetMass = totalMass + fuelAmount;
    float dryMass = totalMass;
    float isp = 300.0f;
    float g0 = 9.81f;

    float deltaV = 0.0f;
    if (dryMass > 0 && wetMass > dryMass) {
        deltaV = isp * g0 * logf(wetMass / dryMass);
    }

    bool budgetValid = budget >= (totalMass * 5.0f + fuelAmount * 2.0f);
    bool powerValid = availablePower >= 150.0f;

    std::string status = (budgetValid && powerValid) ? "NOMINAL" : "CONSTRAINTS EXCEEDED";

    char buffer[256];
    snprintf(buffer, sizeof(buffer), "Status: %s | Delta-V: %.1f m/s | Burn Time: %.1fs",
             status.c_str(), deltaV, fuelAmount / 10.0f);

    return env->NewStringUTF(buffer);
}