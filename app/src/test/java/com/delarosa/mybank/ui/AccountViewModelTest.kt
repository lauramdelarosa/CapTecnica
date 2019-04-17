package com.delarosa.mybank.ui

import com.delarosa.mybank.ui.account.AccountViewModel
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Test

class AccountViewModelTest {
    private lateinit var viewModel: AccountViewModel

    @Before
    fun setUp() {
        viewModel = AccountViewModel()
    }

    @Test
    fun nullDataValidateData() {
        // Arrange


        // Act
        val costumerId = ""
        val name = ""
        val surname = ""
        val email = ""
        val mobile = ""
        val password = ""

        // Assert
        assertEquals(viewModel.validateData(costumerId, name, surname, email, mobile, password), false)
    }

    @Test
    fun invalidDataValidateData() {
        // Arrange

        // Act
        val costumerId = "12345"
        val name = "laura"
        val surname = "lau"
        val email = ""
        val mobile = "369369369"
        val password = "laura123"

        // Assert
        assertFalse(viewModel.validateData(costumerId, name, surname, email, mobile, password))
    }

    @Test
    fun notValidEmail() {
        // Arrange
        // Act
        val email = ""
        // Assert
        assertFalse(viewModel.isValidEmail(email))
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
