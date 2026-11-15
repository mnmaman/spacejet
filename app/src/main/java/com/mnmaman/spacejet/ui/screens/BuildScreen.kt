package com.mnmaman.spacejet.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mnmaman.spacejet.engine.PhysicsEngine

@Composable
fun BuildScreen() {
    var totalMass by remember { mutableStateOf("2500") }
    var fuelAmount by remember { mutableStateOf("1000") }
    var availablePower by remember { mutableStateOf("200") }
    var budget by remember { mutableStateOf("50000") }
    var telemetryResult by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("SpaceJet Mission Designer", style = MaterialTheme.typography.headlineMedium)

        OutlinedTextField(
            value = totalMass,
            onValueChange = { totalMass = it },
            label = { Text("Total Mass (kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = fuelAmount,
            onValueChange = { fuelAmount = it },
            label = { Text("Fuel Amount (kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = availablePower,
            onValueChange = { availablePower = it },
            label = { Text("Available Power (W)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = budget,
            onValueChange = { budget = it },
            label = { Text("Budget ($)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val massVal = totalMass.toFloatOrNull() ?: 0f
                val fuelVal = fuelAmount.toFloatOrNull() ?: 0f
                val powerVal = availablePower.toFloatOrNull() ?: 0f
                val budgetVal = budget.toFloatOrNull() ?: 0f

                telemetryResult = PhysicsEngine.nativeCalculateTelemetry(massVal, fuelVal, powerVal, budgetVal)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate Telemetry & Validate")
        }

        telemetryResult?.let { result ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Text(
                    text = result,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BuildScreenPreview() {
    MaterialTheme {
        BuildScreen()
    }
}