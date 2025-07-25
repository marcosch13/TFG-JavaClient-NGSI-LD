# Based on https://stackoverflow.com/a/57886655
FROM python:3.9-slim as base

ENV PYTHONFAULTHANDLER=1 \
    PYTHONHASHSEED=random \
    PYTHONUNBUFFERED=1

# Set hierarchy with folders
ENV APP_NAME=scorpio-notifier-tester
ENV APP_DIR=/opt/${APP_NAME}
RUN mkdir -p ${APP_DIR}
WORKDIR ${APP_DIR}

FROM base as builder

ENV PIP_DEFAULT_TIMEOUT=100 \
    PIP_DISABLE_PIP_VERSION_CHECK=1 \
    PIP_NO_CACHE_DIR=1 \
    POETRY_VERSION=1.5.0

RUN pip install "poetry==$POETRY_VERSION"
RUN python -m venv /venv

RUN apt-get update && apt-get install git -y

# Copy ngsi_ld_models dependency
RUN mkdir -p /ngsi-ld-models
#COPY ngsi-ld-models /ngsi-ld-models
COPY src/main/java/org/openapitools/client/model /ngsi-ld-models


# Copy app artifacts
#COPY docker/${APP_NAME}/pyproject.toml docker/${APP_NAME}/poetry.lock ./     EL ARCHIVO poetry.lock ARCHIVO NO ESTÁ
COPY docker/${APP_NAME}/pyproject.toml ./
COPY docker/${APP_NAME}/poetry.toml ./
RUN poetry install --no-root
RUN poetry export -f requirements.txt --without-hashes | /venv/bin/pip install -r /dev/stdin



COPY docker/${APP_NAME}/ .
RUN poetry build && /venv/bin/pip install dist/*.whl

FROM base as final

COPY --from=builder /venv /venv
COPY --from=builder ${APP_DIR} .
COPY docker/${APP_NAME}/docker-entrypoint.sh .
RUN chmod +x docker-entrypoint.sh

CMD ["./docker-entrypoint.sh"]
