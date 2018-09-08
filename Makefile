.phony: clean

clean:
	@mvn clean

report:
	@mvn clean test jacoco:resport coveralss:report

compile:
	@mvn compile
