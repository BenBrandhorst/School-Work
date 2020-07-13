from random import randrange
import logging
import boto3
from botocore.exceptions import ClientError

def delete():
    
   # Delete the object
    s3 = boto3.client('s3')
    try:
        s3.delete_object(Bucket='benbrandhorst1', Key='Uploaded.txt')
    except ClientError as e:
        logging.error(e)
        return False
    return True
    