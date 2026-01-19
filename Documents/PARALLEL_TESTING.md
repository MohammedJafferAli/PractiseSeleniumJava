# Parallel Testing with TestNG

## Overview
Parallel testing is configured using TestNG to execute tests concurrently, reducing overall execution time.

## Configuration

### 1. **Thread-Safe WebDriver**
BaseTest uses `ThreadLocal<WebDriver>` to ensure each thread has its own WebDriver instance:

```java
protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

protected WebDriver getDriver() {
    return driver.get();
}
```

### 2. **TestNG Suite Configuration**

#### Main Suite (testng.xml)
- **Suite Level**: `parallel="tests"` with `thread-count="3"`
- **Test Level**: `parallel="methods"` with `thread-count="2"`
- Tests grouped by functionality

#### Smoke Suite (testng-smoke.xml)
- Quick validation tests
- `parallel="tests"` with `thread-count="4"`

## Test Groups

### Login Tests
- LoginTest
- ImplicitWaitTest
- FindElementsByLocators
- FindElementsByXpath
- FindElementByCssSelector

### Dropdown Tests
- AutoSuggestDropDownCountry
- DynamicDropDownSelectCity
- PractiseStaticDropDown
- PraciseDDPassangerList

### Alert and Window Tests
- AcknowledgeAlert
- GetAlertMessage
- HandleWindowsUsingIterator
- HandleWindowsUsingLoop

### Table and Pagination Tests
- WebTables
- WebTableGetPrice
- Pagination

### Actions and Frames Tests
- ActionsTest
- FramesTest
- CheckBoxes

### Advanced Tests
- ExcelDownloadModifyUploadTest
- ExplicitWaitTest
- HandleCalenderToday
- NavigationUsingSelenium
- PageScrollingUsingJSExecutor
- TakeScreenShots

## Execution Commands

### Run Full Suite
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### Run Smoke Tests
```bash
mvn clean test -DsuiteXmlFile=testng-smoke.xml
```

### Run with Custom Thread Count
```bash
mvn clean test -DsuiteXmlFile=testng.xml -Dthreadcount=5
```

## Parallel Execution Levels

### 1. **Suite Level** (`parallel="tests"`)
- Different `<test>` tags run in parallel
- Each test group runs independently

### 2. **Test Level** (`parallel="methods"`)
- Methods within a test run in parallel
- Faster execution within each group

### 3. **Class Level** (`parallel="classes"`)
- Different test classes run in parallel

## Benefits

✅ **Faster Execution**: 3-5x faster than sequential
✅ **Resource Optimization**: Better CPU utilization
✅ **Early Feedback**: Quick test results
✅ **Scalable**: Easy to adjust thread count
✅ **Thread-Safe**: No race conditions

## Best Practices

1. **Independent Tests**: Each test should be independent
2. **Thread-Safe Code**: Use ThreadLocal for shared resources
3. **Optimal Thread Count**: CPU cores × 2
4. **Test Grouping**: Group related tests together
5. **Avoid Dependencies**: Minimize test dependencies

## Thread Count Guidelines

- **Local Machine**: 2-4 threads
- **CI/CD Server**: 4-8 threads
- **Cloud Grid**: 10+ threads

## Monitoring

- Check TestNG reports in `target/surefire-reports/`
- Review execution time per test
- Identify bottlenecks and optimize

## Troubleshooting

### Issue: Tests fail in parallel but pass sequentially
**Solution**: Check for shared state, use ThreadLocal

### Issue: Resource contention
**Solution**: Reduce thread count or add waits

### Issue: Flaky tests
**Solution**: Improve synchronization, use explicit waits
