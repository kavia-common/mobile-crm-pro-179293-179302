#!/bin/bash
cd /home/kavia/workspace/code-generation/mobile-crm-pro-179293-179302/crm_mobile_frontend
./gradlew lint
LINT_EXIT_CODE=$?
if [ $LINT_EXIT_CODE -ne 0 ]; then
   exit 1
fi

