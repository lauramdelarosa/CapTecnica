package com.delarosa.mybank.ui

import com.delarosa.mybank.ui.transaction.TransactionViewModel
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Test

class TransactionViewModelTest {


    private lateinit var viewModel: TransactionViewModel

    @Before
    fun setUp() {
        viewModel = TransactionViewModel()
    }

    @Test
    fun nullDataValidateData() {
        // Arrange


        // Act
        val costumerId = ""
        val productNumber = ""
        val amount = ""

        // Assert
        assertEquals(viewModel.validateData(costumerId, productNumber, amount), false)
    }

    @Test
    fun invalidDataValidateData() {
        // Arrange

        // Act
        val costumerId = ""
        val productNumber = "987654321"
        val amount = "4000"

        // Assert
        assertFalse(viewModel.validateData(costumerId, productNumber, amount))
    }


    @Test
    fun notValidText() {
        // Arrange
        // Act
        val text = ""
        // Assert
        assertFalse(viewModel.isValidText(text))
    }

    @Test
    fun validText() {
        // Arrange
        // Act
        val text = "abcd"
        // Assert
        assertTrue(viewModel.isValidText(text))
    }


}