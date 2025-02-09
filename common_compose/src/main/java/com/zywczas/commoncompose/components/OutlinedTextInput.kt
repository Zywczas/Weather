package com.zywczas.commoncompose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import java.util.regex.Pattern

@Composable
fun OutlinedTextInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    regexFilter: String? = null
) {
    val pattern: Pattern? = regexFilter?.let { remember { Pattern.compile(regexFilter) } }
    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->
            if (pattern != null) {
                if (pattern.matcher(newValue).matches()) {
                    onValueChange(newValue)
                }
            } else {
                onValueChange(newValue)
            }
        },
        modifier = modifier.fillMaxWidth(),
    )
}
