package com.banap.banap.field.registration.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.banap.banap.ui.theme.AZUL_ESCURO
import com.banap.banap.ui.theme.BRANCO
import com.banap.banap.ui.theme.PRETO
import com.banap.banap.ui.theme.Typography
import com.banap.banap.ui.theme.VERDE_CLARO
import com.banap.banap.validation.cultivation.data.validationDataCultivation
import com.banap.banap.validation.cultivation.model.CultivationTextFieldFormEvent
import com.banap.banap.validation.cultivation.model.CultivationTextFieldViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun dropdownTextField (

) : Boolean {
    val context = LocalContext.current

    val viewModelCultivation = viewModel<CultivationTextFieldViewModel>()
    val stateCultivation = viewModelCultivation.state

    var isCultivationValidated by remember {
        mutableStateOf(false)
    }

    isCultivationValidated = validationDataCultivation(
        context = context,
        viewModelCultivation = viewModelCultivation,
        stateCultivation = stateCultivation
    )

    var isExpanded by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .fillMaxWidth(),
    ) {
        Column (
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Text(
                text = "Cultura",
                style = Typography.titleMedium,
                color = PRETO
            )

            ExposedDropdownMenuBox(
                expanded = isExpanded,
                onExpandedChange = {
                    isExpanded = it
                }
            ) {
                OutlinedTextField(
                    value = stateCultivation.cultivation,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                    },
                    colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                        unfocusedContainerColor = VERDE_CLARO,
                        focusedContainerColor = VERDE_CLARO,
                        unfocusedTrailingIconColor = BRANCO,
                        focusedTrailingIconColor = BRANCO,
                        unfocusedTextColor = BRANCO,
                        focusedTextColor = BRANCO,
                        focusedPlaceholderColor = BRANCO,
                        unfocusedPlaceholderColor = BRANCO,
                        focusedBorderColor = AZUL_ESCURO,
                        unfocusedBorderColor = BRANCO
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    placeholder = {
                        Text(
                            text = "Escolha uma cultura",
                            fontWeight = FontWeight.SemiBold
                        )
                    },
                    shape = RoundedCornerShape(7.dp),
                    textStyle = Typography.headlineSmall
                )

                ExposedDropdownMenu(
                    expanded = isExpanded,
                    onDismissRequest = {
                        isExpanded = false
                    },
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(7.dp)
                        )
                        .background(BRANCO)
                ) {
                    DropdownMenuItem(
                        onClick = {
                            viewModelCultivation.onEvent(CultivationTextFieldFormEvent.CultivationChanged("Banana Nanica"))
                            viewModelCultivation.onEvent(CultivationTextFieldFormEvent.Submit)
                            isExpanded = false
                        },
                        text = {
                            Text(
                                text = "Banana nanica",
                                style = Typography.bodyLarge,
                                fontWeight = FontWeight.SemiBold,
                                color = VERDE_CLARO
                            )
                        }
                    )

                    DropdownMenuItem(
                        onClick = {
                            viewModelCultivation.onEvent(CultivationTextFieldFormEvent.CultivationChanged("Banana Prata"))
                            viewModelCultivation.onEvent(CultivationTextFieldFormEvent.Submit)
                            isExpanded = false
                        },
                        text = {
                            Text(
                                text = "Banana prata",
                                style = Typography.bodyLarge,
                                fontWeight = FontWeight.SemiBold,
                                color = VERDE_CLARO
                            )
                        }
                    )

                    DropdownMenuItem(
                        onClick = {
                            viewModelCultivation.onEvent(CultivationTextFieldFormEvent.CultivationChanged("Banana Maça"))
                            viewModelCultivation.onEvent(CultivationTextFieldFormEvent.Submit)
                            isExpanded = false
                        },
                        text = {
                            Text(
                                text = "Banana maça",
                                style = Typography.bodyLarge,
                                fontWeight = FontWeight.SemiBold,
                                color = VERDE_CLARO
                            )
                        }
                    )

                    DropdownMenuItem(
                        onClick = {
                            viewModelCultivation.onEvent(CultivationTextFieldFormEvent.CultivationChanged("Banana da Terra"))
                            viewModelCultivation.onEvent(CultivationTextFieldFormEvent.Submit)
                            isExpanded = false
                        },
                        text = {
                            Text(
                                text = "Banana da terra",
                                style = Typography.bodyLarge,
                                fontWeight = FontWeight.SemiBold,
                                color = VERDE_CLARO
                            )
                        }
                    )

                    DropdownMenuItem(
                        onClick = {
                            viewModelCultivation.onEvent(CultivationTextFieldFormEvent.CultivationChanged("Banana Ouro"))
                            viewModelCultivation.onEvent(CultivationTextFieldFormEvent.Submit)
                            isExpanded = false
                        },
                        text = {
                            Text(
                                text = "Banana ouro",
                                style = Typography.bodyLarge,
                                fontWeight = FontWeight.SemiBold,
                                color = VERDE_CLARO
                            )
                        }
                    )
                }
            }
        }
    }

    return isCultivationValidated
}