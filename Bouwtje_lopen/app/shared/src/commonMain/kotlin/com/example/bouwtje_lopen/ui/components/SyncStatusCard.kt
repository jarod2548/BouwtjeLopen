package com.example.bouwtjelopen.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SyncStatusCard(
    isOnline: Boolean,
    pendingItems: Int,
    lastSync: String
) {
    val statusColor =
        if (isOnline) {
            Color(0xFF2E7D32)
        } else {
            Color(0xFFC62828)
        }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = if (isOnline) {
                            "Online"
                        } else {
                            "Offline"
                        },
                        fontWeight = FontWeight.Bold,
                        color = statusColor
                    )

                    Text(
                        text = "Laatst gesynchroniseerd: $lastSync",
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                IconButton(
                    onClick = {
                        // Later: synchronisatie starten
                    }
                ) {
                }
            }

            if (pendingItems > 0) {
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "$pendingItems items wachten op synchronisatie",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}