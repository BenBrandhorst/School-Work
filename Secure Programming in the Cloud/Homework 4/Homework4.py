# File: Homework4.py
# Author: Ben Brandhorst
# Date: May 2nd, 2020
# Purpose: SDEV400 Homework

from random import randrange
import logging
import boto3
import botocore
import time
from boto3.dynamodb.conditions import Key, Attr
from botocore.exceptions import ClientError
strength, dexterity, constitution, intelligence, wisdom, charisma = 0,0,0,0,0,0
name, charClass, equipment = 'None', 'None', 'None'


# Prints menu with ASCII sword
def print_menu():    
    print (9 * ' ', '/>________________________________', 33 *' ', '________________________________<\ ')
    print ('[########[]_________________________________)','SDEV400 RPG Character Generator', '(_________________________________[]########]')
    print (9 * ' ', '\>', 97 * ' ','</')
    print ("Welcome to the Role Playing Game character generator")
    print ('')
    print ('1. Create a new character')
    print ('2. Edit an existing character')
    print ('3. View all saved characters')
    print ('4. Export a character')
    print ('5. Delete a character')
    print ('6. Exit program')
    print (122 * '-')
    
# Function to create a role playing game character
def charCreator():
    global name
    name = input("Enter your adventurer's name: ")
    global charClass
    charClass = input ('Enter your character class: ')
    print ("Your adventurer's name is: " + name)
    print ('Your class is: '+charClass)
    loop=True
    # Loop that randomly generates rpg stats with numbers in a range of 3-18 (3 six sided dice rolls)
    while loop:
        print ('')
        global strength
        strength = randrange(3,18,1)
        # Converts value of variable to string format for display
        print ('Strength: '+str(strength))
        global dexterity
        dexterity = randrange(3,18,1)
        print ('Dexterity: '+str(dexterity))
        global constitution
        constitution = randrange(3,18,1)
        print ('Constitution: '+str(constitution))
        global intelligence
        intelligence = randrange(3,18,1)
        print ('Intelligence: '+str(intelligence))
        global wisdom
        wisdom = randrange(3,18,1)
        print ('Wisdom: '+str(wisdom))
        global charisma
        charisma = randrange(3,18,1)
        print ('Charisma: '+str(charisma))
        print ('')
        # Selecting yes breaks the loop and runs ths selectEquip() function
        select = input('Do you want to keep these stats? ')
        if select.capitalize() == ('Yes') or select.capitalize() == ('Y'):
            print('Yes selected')
            print('')
            selectEquip()
            loop=False
        # Selecting no generates a new set of stats
        elif select.capitalize() == ('No') or select.capitalize() == ('N'):
            print('You have selected No')
        else: 
            print('Please enter one of the following: "Y", "yes", "N", or "No"')

# Gives users a pool of 50 gold to purchase starting items with
def selectEquip():
    money = 50
    global equipment
    equipment = ''
    loop = True
    print ('Your character starts with 50 gold. Please select from the equipment below: ')
    while loop:
        print ('1. Dagger (5 gold) ')
        print ('2. Short Sword (10 gold) ')
        print ('3. Long Sword (15 gold) ')
        print ('4. Axe (10 gold) ')
        print ('5. Quarterstaff (5 gold)')
        print ('6. Mace (10 gold' )
        print ('7. Short Bow (5 gold) ')
        print ('8. Long Bow (10 gold' )
        print ('9. Cloth Armor (5 gold)')
        print ('10. Leather Armor (10 gold)')
        print ('11. Chainmail (20 gold)')
        print ('12. Plate Armor (35 gold)')
        print ('13. Camping Supplies (10 gold)')
        print ('14. Rations (5 gold)')
        print ('15. Bandages (5 gold)')
        print ('16. Exit and save character information')
        # Prompts users to select a menu item
        select = input('Please select your items for purchase. You have '+str(money)+' gold remaining. ')
        # Matches user input to a selection, subtracts money from their pool, and appends their equipment list with items purchased
        if select==('1'):
            # Verifies that users have enough gold left to purchase this item
            if (money < 5):
                # If not they are given a warning and brought back to the purchase menu
                print('')
                print('You do not have the money for this item. Please try again.')
                print('')
            else:
                # Otherwise they purchase the item, gold is subtracted, and the equipment added to their equipment list
                print('')
                print ('Dagger purchased')
                print ('')
                money = money - 5
                equipment += 'Dagger'
                equipment += ', '
        if select==('2'):
            if (money < 10):
                print('')
                print('You do not have the money for this item. Please try again.')
                print('')
            else:
                print('Short Sword purchased')
                print('')
                money = money - 10
                equipment += 'Short Sword'
                equipment += ', '
        if select==('3'):
            if (money < 15):
                print('')
                print('You do not have the money for this item. Please try again.')
                print('')
            else:
                print('')
                print('Long Sword purchased')
                print('')
                money = money - 15
                equipment += 'Long Sword'
                equipment += ', '
        if select==('4'):
            if (money < 10):
                print('')
                print('You do not have the money for this item. Please try again.')
                print('')
            else:
                print('')
                print('Axe purchased')
                print('')
                money = money - 10
                equipment += 'Axe'
                equipment += ', '
        if select==('5'):
            if (money < 5):
                print('')
                print('You do not have the money for this item. Please try again.')
                print('')
            else:
                print('')
                print('Quarterstaff purchased')
                print('')
                money = money - 5
                equipment += 'Quarterstaff'
                equipment += ', '
        if select==('6'):
            if (money < 10):
                print('')
                print('You do not have the money for this item. Please try again.')
                print('')
            else:
                print('')
                print('Mace purchased')
                print('')
                money = money - 10
                equipment += 'Mace'
                equipment += ', '
        if select==('7'):
            if (money < 5):
                print('')
                print('You do not have the money for this item. Please try again.')
                print('')
            else:
                print('')
                print('Short Bow purchased')
                print('')
                money = money - 5
                equipment += 'Short Bow'
                equipment += ', '
        if select==('8'):
            if (money < 10):
                print('')
                print('You do not have the money for this item. Please try again.')
                print('')
            else:
                print('')
                print('Long Bow purchased')
                print('')
                money = money - 10
                equipment += 'Long Bow'
                equipment += ', '
        if select==('9'):
            if (money < 5):
                print('')
                print('You do not have the money for this item. Please try again.')
                print('')
            else:
                print('')
                print('Cloth Armor purchased')
                print('')
                money = money - 5
                equipment += 'Cloth Armor'
                equipment += ', '
        if select==('10'):
            if (money < 10):
                print('')
                print('You do not have the money for this item. Please try again.')
                print('')
            else:
                print('')
                print('Leather Armor purchased')
                print('')
                money = money - 10
                equipment += 'Leather Armor'
                equipment += ', '
        if select==('11'):
            if (money < 20):
                print('')
                print('You do not have the money for this item. Please try again.')
                print('')
            else:
                print('')
                print('Chainmail purchased')
                print('')
                money = money - 20
                equipment += 'Chainmail'
                equipment += ', '
        if select==('12'):
            if (money < 35):
                print('')
                print('You do not have the money for this item. Please try again.')
                print('')
            else:
                print('')
                print('Plate Armor purchased')
                print('')
                money = money - 35
                equipment += 'Plate Armor'
                equipment += ', '
        if select==('13'):
            if (money < 10):
                print('')
                print('You do not have the money for this item. Please try again.')
                print('')
            else:
                print('')
                print('Camping Supplies purchased')
                print('')
                money = money - 10
                equipment += 'Camping Supplies'
                equipment += ', '
        if select==('14'):
            if (money < 5):
                print('')
                print('You do not have the money for this item. Please try again.')
                print('')
            else:
                print('')
                print('Rations purchased')
                print('')
                money = money - 5
                equipment += 'Rations'
                equipment += ', '
        if select==('15'):
            if (money < 5):
                print('')
                print('You do not have the money for this item. Please try again.')
                print('')
            else:
                print('')
                print('Bandages purchased')
                print('')
                money = money - 5
                equipment += 'Bandages'
                equipment += ', '
        # Character information is saved when exit is selected
        if select.capitalize() == ('16'):
            equipment += ' '
            saveChar()
            print('')
            print('Character information saved')
            print('')
            loop=False

# Function to create new item in dynamodb table with the variables used in character creation
def saveChar():
    # Sort is only included because I couldn't get the table to work without a sort key
    sort = 1
    dynamodb = boto3.resource('dynamodb')
    table = dynamodb.Table('RPG')
    table.put_item(
        Item={
            'Name': name,
            'Class': charClass,
            'Strength': strength,
            'Dexterity': dexterity,
            'Constitution': constitution,
            'Intelligence': intelligence,
            'Wisdom': wisdom,
            'Charisma': charisma,
            'Equipment': equipment,
            'Sort': sort
                }
        )
# Function to edit existing character records        
def editChar():
    global name, charClass, equipment
    global strength, dexterity, constitution, intelligence, wisdom, charisma
    loop=True      
    while loop:
        select = input('Please enter the name of the character you wish to edit. ')
        # Queries the database to confirm the record users want to edit exists 
        dynamodb = boto3.resource('dynamodb')
        table = dynamodb.Table('RPG')
        response = table.query( 
        KeyConditionExpression=Key('Name').eq(select))
        # If the record does not exist, returns and error and sends back to main menu
        if not response['Items']:
            print('That is not a valid character name. Please try again. ')
            break;
        # If record exists, fills global variables with info from database for editing
        for i in response['Items']:
            print('Your character name is ',i['Name'])
            name = i['Name']
            charClass = i['Class']
            equipment = i['Equipment']
            strength = i['Strength']
            dexterity = i['Dexterity']
            constitution = i['Constitution']
            intelligence = i['Intelligence']
            wisdom = i['Wisdom']
            charisma = i['Charisma']
            
        answer = input('Please select what you would like to edit for this character: ')
        # Filters user input to confirm it matches editable variables
        if answer==('name') or answer==('charClass') or answer==('equipment') or answer==('strength') or answer==('dexterity') or answer==('constitution') or answer==('intelligence') or answer==('wisdom') or answer==('charisma'):
            # Requests new value for that field
            stats = input('Please enter the new value: ')
            # After validating input is that of an editable variable, uses value
            # of input as a variable name and assigns value of stats input to variable
            globals()[answer] = stats
        # Otherwise prompts users to input one of the editable variable names    
        else:
            print('Please enter one of the following: name, charClass, equipment, strength, dexterity, constitution, intelligence, wisdom, or charisma ')
            continue;
        answer = input('Would you like to edit something else? ')
        # Continues loop
        if answer==('yes'):
            continue;
        # Saves character and breaks loop
        elif answer==('no'):
            saveChar()
            loop = False
        else:
            print('Please enter yes or no')
            
# Function that scans database items and prints Name field for all records
def viewChars():
    dynamodb = boto3.resource('dynamodb')
    table = dynamodb.Table('RPG')
    response = table.scan() 
    for i in response['Items']:
        print(i['Name'])

# Function queries database to confirm item exists and deletes it        
def deleteChar():
    loop=True
    while loop:
        select = input('Please enter the name of the character you wish to delete: ')
        dynamodb = boto3.resource('dynamodb')
        table = dynamodb.Table('RPG')
        response = table.query( 
        KeyConditionExpression=Key('Name').eq(select))
        # If user input does not return an Item, gives error and sends back to main menu
        if not response['Items']:
            print('')
            print('That is not a valid character name. Please try again. ')
            break;
        # Otherwise tries to delete the item based on the Name and Sort fields    
        try:
            response = table.delete_item( 
                Key={
                    'Name': select,
                    'Sort': 1
                }
            )
        except ClientError as e:
            if e.response['Error']['Code'] == "ConditionalCheckFailedException":
                print(e.response['Error']['Message'])
            else:
                raise
        else:
            print(select, ' was successfully deleted')
            # Simple loop which allows users to delete another character or return to main menu
            select = input('Would you like to delete another character?')
            if select.capitalize() == ('Yes'):
                    continue;
            elif select.capitalize() == ('No'):
                    loop = False
            else:
                print('Please select yes or no' )

# Function saves Character info to txt file and exports to S3 Bucket                
def exportChar():
    global name, charClass, equipment
    global strength, dexterity, constitution, intelligence, wisdom, charisma
    loop=True
    while loop:
        select = input('Please enter the name of the character you wish to export: ')
        dynamodb = boto3.resource('dynamodb')
        table = dynamodb.Table('RPG')
        response = table.query( 
        KeyConditionExpression=Key('Name').eq(select))
        # Confirms user input matches Name field in table
        if not response['Items']:
            print('')
            print('That is not a valid character name. Please try again. ')
            break;
        for i in response['Items']:
            print('You have selected the character: ',i['Name'])
            # Formats variables for exporting to txt file in S3 bucket
            name = 'Name:', i['Name']
            charClass = 'Class:', i['Class']
            equipment = 'Equipment:', i['Equipment']
            strength = 'Strength', i['Strength']
            dexterity = 'Dexterity:', i['Dexterity']
            constitution = 'Constitution:', i['Constitution']
            intelligence = 'Intelligence:', i['Intelligence']
            wisdom = 'Wisdom:', i['Wisdom']
            charisma = 'Charisma:', i['Charisma']
            
            # Creates temp.txt file
            file=open("temp.txt","w")
            # Writes character info to text file
            file.write(str(name))
            file.write(str(charClass))
            file.write(str(equipment))
            file.write(str(strength))
            file.write(str(dexterity))
            file.write(str(constitution))
            file.write(str(intelligence))
            file.write(str(wisdom))
            file.write(str(charisma))
            # Closes text file
            file.close()
        try:
            # Uploads text file to S3 bucket with a filename based on character name
             s3_client = boto3.client('s3')
             file = str(name)
             suffix = 'txt'
             filename = '.'.join([file, suffix])
             response = s3_client.upload_file('/home/ec2-user/environment/temp.txt','ben.brandhorst.homework4', filename)
             print ('Your character sheet has been uploaded to ben.brandhorst.homework4 S3 bucket as:', filename)
         
        except ClientError as e:
            logging.error(e)
            return False
        return True
        

# Loop for menu that runs until "Exit Program" is selected     
loop=True      
while loop:
    print_menu()
    choice = input('Enter your choice [1-6]: ')
    if choice==('1'):
        # Runs charCreator() function
        charCreator()
    elif choice==('2'):
        # Runs editChar() function
        editChar()
    elif choice==('3'):
        # Runs viewChars() function
        viewChars()
    elif choice==('4'):
        # Runs exportChar() function
        exportChar()
    elif choice==('5'):
        # Runs deleteChar() function
        deleteChar()
    elif choice==('6'):
        # Exits program
        print("You have selected 'Exit Program'")
        loop=False 
    else:
        # Any integer inputs other than values 1-6 returns this error
        input("Wrong option selection. Enter any key to try again.")
        