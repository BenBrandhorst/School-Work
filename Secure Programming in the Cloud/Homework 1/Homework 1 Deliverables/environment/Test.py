from random import randrange
import logging
import boto3
from botocore.exceptions import ClientError

def copy_object():
    # Copies Uploaded2.txt from benbrandhorst1 bucket to benbrandhorst2 bucket and renames file Copie
    try:
        copy_source = { 'Bucket': 'benbrandhorst1', 'Key': 'Uploaded2.txt'}
        s3 = boto3.resource('s3')
        bucket = s3.Bucket('benbrandhorst2')
        bucket.copy(copy_source, 'Copied1.txt')
        print('Copied Uploaded2.txt from bucket benbrandhorst1 to bucket benbrandhorst2 and renamed the file Copied1.txt. ')
    except ClientError as e:
        logging.error(e)
        return False
    return True
    
copy_object()
    
    
   

