/*
 * ========================================================================
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ========================================================================
 */

package al.selenium.in.rush.browse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class RBALSeleniumTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        ChromeDriverService chromeDriverService = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("drivers/chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        driver = new ChromeDriver(chromeDriverService);
    }

    @Test
    void testChromeRBAL() {
        driver.get("https://24.raiffeisen.al");
        assertThat(driver.getTitle(), is("Raiffeisen BANK"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
