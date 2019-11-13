.phony: clean

clean:
	@mvn clean

report-online:
	@mvn clean test jacoco:report coveralls:report
	
report-offline:
	@mvn clean test jacoco:report
	@google-chrome target/site/jacoco/index.html
	
docs-offline:
	@mvn javadoc:javadoc
	@google-chrome target/site/apidocs/index.html

compile:
	@mvn compile
