# Enterprise Folder Structure

## Current Organization (Enterprise Standard)

```
src/test/java/
├── base/                    # Base test classes
│   └── BaseTest.java       # Common test setup/teardown
│
├── pages/                   # Page Object Model classes
│   ├── BasePage.java       # Base page with common operations
│   ├── LoginPage.java
│   ├── SecureLoginPage.java
│   ├── PasswordResetPage.java
│   ├── ExcelUploadDownloadPage.java
│   ├── CheckoutPage.java
│   ├── ActionsPage.java
│   ├── AlertPage.java
│   ├── CheckBoxPage.java
│   ├── FramesPage.java
│   ├── WebTablePage.java
│   ├── DropdownPage.java
│   ├── WindowPage.java
│   ├── CalendarPage.java
│   └── PaginationPage.java
│
├── tests/                   # All test classes
│   ├── LoginTest.java
│   ├── ExcelDownloadModifyUploadTest.java
│   ├── ImplicitWaitTest.java
│   ├── ExplicitWaitTest.java
│   ├── ActionsTest.java
│   ├── FramesTest.java
│   ├── AcknowledgeAlert.java
│   ├── GetAlertMessage.java
│   ├── CheckBoxes.java
│   ├── WebTables.java
│   ├── WebTableGetPrice.java
│   ├── AutoSuggestDropDownCountry.java
│   ├── DynamicDropDownSelectCity.java
│   ├── PractiseStaticDropDown.java
│   ├── PraciseDDPassangerList.java
│   ├── NavigationUsingSelenium.java
│   ├── FindElementsByLocators.java
│   ├── FindElementsByXpath.java
│   ├── FindElementByCssSelector.java
│   ├── HandleWindowsUsingIterator.java
│   ├── HandleWindowsUsingLoop.java
│   ├── HandleCalenderToday.java
│   ├── Pagination.java
│   ├── TakeScreenShots.java
│   └── PageScrollingUsingJSExecutor.java
│
├── utils/                   # Utility/Helper classes
│   ├── WaitHelper.java     # Explicit wait operations
│   ├── ExcelHelper.java    # Excel file operations
│   ├── FileHelper.java     # File system operations
│   ├── WindowHelper.java   # Window management
│   ├── JavaScriptHelper.java # JavaScript execution
│   ├── ScreenshotHelper.java # Screenshot capture
│   └── ConfigReader.java   # Configuration management
│
├── concepts/                # Learning concepts (Java Streams, etc.)
│   ├── FilterStream.java
│   ├── MapStream.java
│   └── ProblemsWithRegularMethod.java
│
└── interview/               # Interview practice assignments
    └── LinksOnAPage.java
```

## Enterprise Standards Applied

### 1. **Package Naming Convention**
- All lowercase
- Descriptive names
- Follows Java naming conventions

### 2. **Separation of Concerns**
- **base/**: Framework foundation
- **pages/**: UI interactions (POM)
- **tests/**: Test scenarios
- **utils/**: Reusable utilities
- **concepts/**: Learning materials
- **interview/**: Practice assignments

### 3. **Scalability**
- Easy to add new pages
- Easy to add new tests
- Easy to add new utilities
- Clear organization

### 4. **Maintainability**
- Logical grouping
- Clear responsibilities
- Easy navigation
- Consistent structure

### 5. **Industry Best Practices**
✅ Page Object Model pattern
✅ DRY (Don't Repeat Yourself)
✅ Single Responsibility Principle
✅ Clear package structure
✅ Proper naming conventions
✅ Separation of test logic and page logic
✅ Centralized utilities

## Benefits

1. **Easy Onboarding**: New team members can quickly understand structure
2. **Scalable**: Can grow without becoming messy
3. **Maintainable**: Changes are isolated and easy to implement
4. **Professional**: Follows industry standards
5. **Testable**: Each component can be tested independently
6. **Reusable**: Utilities and pages can be reused across tests
