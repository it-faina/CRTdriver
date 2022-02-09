package org.faina;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppSandboxTest{
    final static Logger log = LoggerFactory.getLogger(AppSandbox.class);

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        log.info("**Test log message**");
        assertTrue( true );
    }
}
