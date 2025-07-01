#!/bin/sh

set -e

# activate our virtual environment here
. /venv/bin/activate

exec uvicorn scorpio_notifier_tester.main:app --host 0.0.0.0 \
     --port 8084 --reload \
     --log-config scorpio_notifier_tester/config/log.yaml
