.phony: clean

clean:
	@mvn clean

report-online:
	@mvn clean test jacoco:resport coveralss:report
	
report-offline:
	@mvn clean test jacoco:report
	@google-chrome target/site/jacoco/index.html

compile:
	@mvn compile
