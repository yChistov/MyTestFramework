package com.mystore.helpers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.mystore.helpers.Driver.screenshot;

public class TestListener implements ITestListener {

  protected Logger logger = LogManager.getLogger("");

  @Override
  public void onTestStart(ITestResult TestResult) {
    logger.info(TestResult.getMethod().getMethodName() + " Started");
  }

  @Override
  public void onTestSuccess(ITestResult TestResult) {
    logger.info(TestResult.getMethod().getMethodName() + " Passed");
  }

  @Override
  public void onTestFailure(ITestResult TestResult) {
    logger.info("Failed because of - " + TestResult.getThrowable());
    screenshot();
  }

  @Override
  public void onTestSkipped(ITestResult TestResult) {
    logger.info("Skipped because of - " + TestResult.getThrowable());
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult TestResult) {}

  @Override
  public void onStart(ITestContext TestContext) {
    logger.info("=========== Start: " + TestContext.getName() + "===============");
  }

  @Override
  public void onFinish(ITestContext TestContext) {
    logger.info("=========== Finish: " + TestContext.getName() + " ===============");
  }
}
