package com.mnmaman.spacejet.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MissionScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Mission Control",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Review completed milestones and telemetry reports.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Flight Report: 003",
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "A giant leap. And back. All systems operated within nominal parameters during lunar orbit insertion.",
                    style = MaterialTheme.typography.bodyMedium
                )

                HorizontalDivider()

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(text = "Apogee", style = MaterialTheme.typography.labelMedium)
                        Text(text = "110 km", style = MaterialTheme.typography.titleMedium)
                    }
                    Column {
                        Text(text = "Fuel Burn", style = MaterialTheme.typography.labelMedium)
                        Text(text = "38%", style = MaterialTheme.typography.titleMedium)
                    }
                    Column {
                        Text(text = "Payload", style = MaterialTheme.typography.labelMedium)
                        Text(text = "2 / 2", style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
        }

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Prepare Next Mission")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MissionScreenPreview() {
    MaterialTheme {
        MissionScreen()
    }
}