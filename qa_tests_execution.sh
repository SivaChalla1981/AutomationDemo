#!/usr/bin/env bash

mvn test -DfailIfNoTests=false -Dbrowser=firefox -Denvironment=qa -Dtest=RunCucumber
