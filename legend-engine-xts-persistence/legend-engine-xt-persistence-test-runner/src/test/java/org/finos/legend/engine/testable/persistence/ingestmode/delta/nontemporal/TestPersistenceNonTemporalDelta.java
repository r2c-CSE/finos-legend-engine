// Copyright 2022 Goldman Sachs
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.finos.legend.engine.testable.persistence.ingestmode.delta.nontemporal;

import org.finos.legend.engine.protocol.pure.v1.model.test.result.TestExecuted;
import org.finos.legend.engine.protocol.pure.v1.model.test.result.TestExecutionStatus;
import org.finos.legend.engine.protocol.pure.v1.model.test.result.TestResult;
import org.finos.legend.engine.testable.persistence.ingestmode.TestPersistenceBase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestPersistenceNonTemporalDelta extends TestPersistenceBase
{

    @Test
    public void testDeltaWithNoAuditingNoDeleteIndicator() throws Exception
    {
        String path = "src/test/resources/non-temporal-delta/persistence_no_audit.txt";
        String persistenceSpec = readPureCode(path);
        TestResult result = testPersistence(persistenceSpec).results.get(0);

        assertTrue(result instanceof TestExecuted);
        Assert.assertEquals(TestExecutionStatus.PASS, ((TestExecuted) result).testExecutionStatus);
        Assert.assertEquals("test::TestPersistence", result.testable);
    }

    @Test
    public void testDeltaWithDateTimeAuditingNoDeleteIndicator() throws Exception
    {
        String path = "src/test/resources/non-temporal-delta/persistence_date_time_audit.txt";
        String persistenceSpec = readPureCode(path);
        TestResult result = testPersistence(persistenceSpec).results.get(0);

        assertTrue(result instanceof TestExecuted);
        Assert.assertEquals(TestExecutionStatus.PASS, ((TestExecuted) result).testExecutionStatus);
        Assert.assertEquals("test::TestPersistence", result.testable);
    }

    @Test
    public void testDeltaWithDateTimeAuditingAndDeleteIndicator() throws Exception
    {
        String path = "src/test/resources/non-temporal-delta/persistence_date_time_audit_delete_indicator.txt";
        String persistenceSpec = readPureCode(path);
        TestResult result = testPersistence(persistenceSpec).results.get(0);

        assertTrue(result instanceof TestExecuted);
        Assert.assertEquals(TestExecutionStatus.PASS, ((TestExecuted) result).testExecutionStatus);
        Assert.assertEquals("test::TestPersistence", result.testable);
    }

    // v2 tests

    @Test
    public void testDeltaWithNoAuditingNoDeleteIndicatorV2() throws Exception
    {
        String path = "src/test/resources/v2/non-temporal-delta/persistence_no_audit.txt";
        String persistenceSpec = readPureCode(path);
        TestResult result = testPersistence(persistenceSpec).results.get(0);

        assertTrue(result instanceof TestExecuted);
        Assert.assertEquals(TestExecutionStatus.PASS, ((TestExecuted) result).testExecutionStatus);
        Assert.assertEquals("test::TestPersistence", result.testable);
    }

    @Test
    public void testDeltaWithDateTimeAuditingNoDeleteIndicatorV2() throws Exception
    {
        String path = "src/test/resources/v2/non-temporal-delta/persistence_date_time_audit.txt";
        String persistenceSpec = readPureCode(path);
        TestResult result = testPersistence(persistenceSpec).results.get(0);

        assertTrue(result instanceof TestExecuted);
        Assert.assertEquals(TestExecutionStatus.PASS, ((TestExecuted) result).testExecutionStatus);
        Assert.assertEquals("test::TestPersistence", result.testable);
    }

    @Test
    public void testDeltaWithDateTimeAuditingAndDeleteIndicatorV2() throws Exception
    {
        String path = "src/test/resources/v2/non-temporal-delta/persistence_date_time_audit_delete_indicator.txt";
        String persistenceSpec = readPureCode(path);
        TestResult result = testPersistence(persistenceSpec).results.get(0);

        assertTrue(result instanceof TestExecuted);
        Assert.assertEquals(TestExecutionStatus.PASS, ((TestExecuted) result).testExecutionStatus);
        Assert.assertEquals("test::TestPersistence", result.testable);
    }
}