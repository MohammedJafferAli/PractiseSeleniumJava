# Selenium WebDriver Automation with Java 11

Enterprise-grade Selenium WebDriver automation framework using Java 11, TestNG, and Page Object Model pattern.

## 🚀 Features

- ✅ **Page Object Model (POM)** - Industry-standard design pattern
- ✅ **SOLID Principles** - Clean, maintainable code architecture
- ✅ **Parallel Testing** - TestNG parallel execution support
- ✅ **Java 11** - Modern Java features (var, List.of, method references)
- ✅ **Thread-Safe** - ThreadLocal WebDriver for parallel execution
- ✅ **Selenium 4.20.0** - Latest Selenium features
- ✅ **WebDriverManager** - Automatic driver management
- ✅ **TestNG 7.10.1** - Advanced test configuration

## 📁 Project Structure

```
src/test/java/
├── base/              # Base test classes
├── pages/             # Page Object Model classes (15 pages)
├── tests/             # Test classes (25+ tests)
├── utils/             # Helper utilities (7 utilities)
├── concepts/          # Java Streams learning
└── interview/         # Practice assignments
```

## 🛠️ Tech Stack

- **Java**: 11
- **Selenium**: 4.20.0
- **TestNG**: 7.10.1
- **WebDriverManager**: 5.8.0
- **Apache POI**: 5.2.4
- **Build Tool**: Maven

## 📋 Prerequisites

- JDK 11 or higher
- Maven 3.6+
- Chrome Browser

## ⚙️ Setup

1. **Clone the repository**
```bash
git clone https://github.com/MohammedJafferAli/PractiseSeleniumJava.git
cd PractiseSeleniumJava
```

2. **Install dependencies**
```bash
mvn clean install
```

3. **Run tests**
```bash
# Run all tests
mvn clean test

# Run specific suite
mvn test -DsuiteXmlFile=testng.xml

# Run smoke tests
mvn test -DsuiteXmlFile=testng-smoke.xml
```

## 🧪 Test Execution

### Sequential Execution
```bash
mvn test -Dtest=LoginTest
```

### Parallel Execution
```bash
mvn test -DsuiteXmlFile=testng.xml -Dthreadcount=4
```

## 📊 Test Categories

- **Login Tests** - Authentication flows
- **Dropdown Tests** - Static, dynamic, auto-suggest
- **Alert & Window Tests** - Alert handling, window switching
- **Table Tests** - Web table operations, pagination
- **Actions Tests** - Mouse, keyboard interactions
- **Advanced Tests** - Excel operations, JS execution, screenshots

## 🏗️ Architecture

### SOLID Principles Applied
- **S**ingle Responsibility - Each class has one purpose
- **O**pen/Closed - Extensible without modification
- **L**iskov Substitution - Proper inheritance
- **I**nterface Segregation - Focused utilities
- **D**ependency Inversion - Depend on abstractions

### Design Patterns
- **Page Object Model** - UI abstraction
- **Factory Pattern** - ChromeOptions creation
- **Singleton Pattern** - Configuration management

## 📚 Documentation

- [Folder Structure](FOLDER_STRUCTURE.md)
- [Parallel Testing](PARALLEL_TESTING.md)
- [Java 11 Features](JAVA_11_FEATURES.md)
- [Refactoring Summary](REFACTORING_SUMMARY.md)

## 🔧 Configuration

### TestNG Suite (testng.xml)
```xml
<suite name="Test Suite" parallel="tests" thread-count="3">
    <test name="Login Tests" parallel="methods" thread-count="2">
        <!-- Test classes -->
    </test>
</suite>
```

### Maven Compiler
```xml
<properties>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
</properties>
```

## 📈 Reports

Test reports are generated in:
- `target/surefire-reports/` - TestNG HTML reports
- `target/surefire-reports/testng-results.xml` - XML results

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 Best Practices

- ✅ Independent tests
- ✅ Explicit waits over implicit
- ✅ Page Object Model
- ✅ Meaningful test names
- ✅ Proper assertions
- ✅ Clean up resources

## 🐛 Troubleshooting

### Driver Issues
```bash
# WebDriverManager handles drivers automatically
# If issues persist, clear cache:
rm -rf ~/.m2/repository/webdriver
```

### Parallel Execution Issues
- Ensure tests are independent
- Use ThreadLocal for WebDriver
- Avoid shared state

## 📞 Contact

**Mohammed Jaffer Ali**
- GitHub: [@MohammedJafferAli](https://github.com/MohammedJafferAli)
- Repository: [PractiseSeleniumJava](https://github.com/MohammedJafferAli/PractiseSeleniumJava)

## 📄 License

This project is open source and available for learning purposes.

## 🌟 Acknowledgments

- Selenium WebDriver community
- TestNG framework
- Page Object Model pattern

---

**Happy Testing! 🚀**
