package com.example.agenda_contatos

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test that validates the application context on a device or emulator.
 */
@RunWith(AndroidJUnit4::class)
class AgendaInstrumentedTest {
    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.agenda_contatos", appContext.packageName)
    }
}
