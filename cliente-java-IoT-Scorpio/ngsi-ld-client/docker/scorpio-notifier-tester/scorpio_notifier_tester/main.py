import logging
#import os
#from time import sleep
from fastapi import FastAPI, Request, status
import json
#import ngsi_ld_client
#from ngsi_ld_client.api_client import ApiClient as NGSILDClient
#from ngsi_ld_client.configuration import Configuration as NGSILDConfiguration
#from scorpio_notifier_tester.check_client import NGSILDHealthInfoClient

logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)


# NGSI-LD Context Broker
#BROKER_URI = os.getenv("BROKER_URI", "http://scorpio:9090/ngsi-ld/v1")

# Context Catalog
#CONTEXT_CATALOG_URI = os.getenv("CONTEXT_CATALOG_URI",
                               # "http://context-catalog:8080/context.jsonld")

# Notifier
#NOTIFIER_URI = os.getenv("NOTIFIER_URI", "http://scorpio-notifier-tester:8084/notify")

# Init NGSI-LD Client
#configuration = NGSILDConfiguration(host=BROKER_URI)
#configuration.debug = True
#ngsi_ld = NGSILDClient(configuration=configuration)

#ngsi_ld_health_info_api = NGSILDHealthInfoClient(
    #url="http://scorpio:9090",
    #headers={"Accept": "application/json"},
    #context="http://context-catalog:8080/context.jsonld")

#ngsi_ld.set_default_header(
    #header_name="Link",
    #header_value='<{0}>; '
               #  'rel="http://www.w3.org/ns/json-ld#context"; '
               #  'type="application/ld+json"'.format(CONTEXT_CATALOG_URI)
#)

#ngsi_ld.set_default_header(
   # header_name="Accept",
   # header_value="application/json"
#)

# Init FastAPI server
app = FastAPI(
    title="Notifier Tester API",
    version="1.0.0")

#@app.on_event("startup")
#async def startup_event():

    # Check if Scorpio API is up
    #ngsi_ld_health_info_api.check_scorpio_status()

    # Check Scorpio build info
    #ngsi_ld_health_info_api.check_scorpio_info()

@app.post("/notify",
          status_code=status.HTTP_200_OK)
async def receiveNotification(request: Request):
    notification = await request.json()
    for entity in notification["data"]:
        logger.info("Entity notification: %s\n" % entity)