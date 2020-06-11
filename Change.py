# Topic: Change Calculator
# The program ask the user to input the cost of the item bought and the paid amount of money for that item, it then uses
# this to compute an appropriate combination of denominations for the buyer's change.

amount = float(input("Enter purchase amount in cedis : "))
paidamount = float(input("Enter paid amount of money in cedis : "))
        
offer = "Offer change:"

# Assigning all possible denominations to zero.
fifty = 0
twenty = 0
ten = 0
five = 0
two = 0
one = 0
pointfive = 0
pointtwo = 0
pointone = 0

# defining the various denominations.
fifty_notes = "fifty cedis"
twenty_notes = "twenty cedis"
ten_notes = "ten cedis"
two_notes = "two cedis"
five_notes = "five cedis"
one_notes = "one cedis"
fifty_coins = "fifty pesawas"
twenty_coins = "twenty pesawas"
ten_coins = "ten pesawas"

if amount == paidamount:
    print("No change")

# Defining what change is.    
change = paidamount - amount                 
 
 # Calculating the buyer's change using the modullo function.
fifty = change//50
twenty = (change-(fifty*50))//20
ten = (change-((fifty*50)+(twenty*20)))//10
five = (change-((fifty*50)+(twenty*20)+(ten*10)))//5
two = (change-((fifty*50)+(twenty*20)+(ten*10)+(five*5)))//2
one = (change-((fifty*50)+(twenty*20)+(ten*10)+(five*5)+(two*2)))//1
pointfive = (change-((fifty*50)+(twenty*20)+(ten*10)+(five*5)+(two*2)+(one*1)))//0.5
pointtwo = (change-((fifty*50)+(twenty*20)+(ten*10)+(five*5)+(two*2)+(one*1)+(pointfive*0.5)))//0.2
pointone = (change-((fifty*50)+(twenty*20)+(ten*10)+(five*5)+(two*2)+(one*1)+(pointfive*0.5)+(pointtwo*0.2)))//0.1

#Printing the various outcomes. 
if change>0:
    print(offer)
    if fifty>0:
        print(fifty, fifty_notes)
    if twenty>0:
        print(twenty, twenty_notes)
    if ten>0:
        print(ten, ten_notes)
    if five>0:
        print(five, five_notes)
    if two>0:
        print(two, two_notes)
    if one>0:
        print(one, one_notes)
    if pointfive>0:
        print(pointfive, fifty_coins)
    if pointtwo>0:
        print(pointtwo, twenty_coins)
    if pointone>0:
        print(pointone, ten_coins)
        