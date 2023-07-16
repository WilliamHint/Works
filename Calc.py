
##Uncomment line 3 for user input
##ip = input("Enter the IP V4 Address you wish to calculate")
ip = "32.20.130.0/17"

##Function that converts a decimal number to binary needs an int
def convertToBinary(octet):
    bin = ""
    i=0
    while i < 8:
        r = octet % 2
        octet = octet // 2
        #print (octet)
        bin = str(r) + bin
        i+=1
    return bin


##Function that converts a binary number to decimal
def convertToDecimal(bin):
    final = 0
    bin = list(bin)
    for i in range(len(bin)):
        digit = bin.pop()
        if (digit=="1"):
            final += (2**i)
        elif (digit=="."):
            final +="."

    return final

##Splits the ip in to the acutal address and the prefix
ipSplit = ip.split("/")
##The prefix
gsm = int((ipSplit[1]))
##The address
network = ipSplit[0]
##Splits the address in to octets
netSplit = network.split(".")

##The first, second third and fourth octets repectivley
fOctet = int(netSplit[0])
sOctet = int(netSplit[1])
tOctet = int(netSplit[2])
foOctet = int(netSplit[3])

##Setting the default values of the subnet mask 
ipClass = "none"
dsm = 0
dsmBin = "none"
rSID =""
##Determining the class, and assinging the default masks
if (int(fOctet) >= 1) and (int(fOctet) <= 126):
    ipClass = "A"
    dsm = 8
    dsmBin = "255.0.0.0"
    rSID+=str(fOctet)
elif (int(fOctet) >= 128) and (int(fOctet) <= 191):
    ipClass = "B"
    dsm = 16
    dsmBin = "255.255.0.0"
    rSID+=str(fOctet)+str(sOctet)
elif (int(fOctet) >= 192) and (int(fOctet) <= 224):
    ipClass = "C"
    dsm = 24
    dsmBin = "255.255.255.0"
    rSID+=str(fOctet)+str(sOctet)+str(tOctet)

##Bits Borrowed
s = gsm - dsm

##Host Bits
h = 32 - gsm

##Number of subnets
S = 2**s

#Host Ip Address
H = 2**h

##Usable host addresses
uH = (2**h)-2 

##Code that prints the subnet mask in binary
netMask=""
for i in range(1,33):
    if i <= gsm:
        netMask+="1"
    else:
        netMask+="0"
    if i%8==0 and i!=32:
        netMask+="."


##Splitting the subnet mask
splitMask = netMask.split(".")


##Wildcard
wC = ""
for i in range(len(netMask)):
    if netMask[i] == "1":
        wC+="0"
    elif netMask[i] == "0":
        wC+="1"
    else:
        wC+="."
wCDec = str(255-(convertToDecimal(splitMask[0])))+"."+str(255-convertToDecimal(splitMask[1]))+"."+str(255-convertToDecimal(splitMask[2]))+"."+str(255-convertToDecimal(splitMask[3]))
wCLast = wCDec.split(".")[3]



##The final subnet Id with decimal numbers
subNetId = str(fOctet)+"."+str(sOctet)+"."+str(tOctet)+"."+(convertToBinary(foOctet))

subNetId=""

##Computes the subnet ID
if gsm > 16 and gsm < 24:
    subNetId=str(fOctet)+"."+str(sOctet)
    bin = convertToBinary(tOctet)
    tOctetBin = ""
    for i in range(8):
        if (splitMask[2][i]) == "0":
            tOctetBin+="0"
        else:

            tOctetBin+=str(bin)[i]
    tOctetBin = convertToDecimal(tOctetBin)
    subNetId += "."+str(tOctetBin)+".0"
elif gsm > 24:
    subNetId=str(fOctet)+"."+str(sOctet)
    subNetId+="."+str(tOctet)
    foOctetBin =""
    bin = convertToBinary(foOctet)
    for i in range(8):
        if(splitMask[3][i]) == "0":
                foOctetBin+="0"
        else:
            foOctetBin+=str(bin)[i]
    foOctetBin = convertToDecimal(foOctetBin)
    subNetId+="."+str(foOctetBin)


subNetSplit = (subNetId.split("."))

    
##Computes the broadcast ID if class is A
if ipClass == "A":
    if gsm > 16 and gsm < 24:
        broadID=str(fOctet)+"."+str(sOctet)
        bin = convertToBinary(tOctet)
        tOctetBin = ""
        for i in range(8):
            if (splitMask[2][i]) == "0":
                tOctetBin+="1"
            else:
                tOctetBin+=str(bin)[i]
        tOctetBin = convertToDecimal(tOctetBin)
        broadID += "."+str(tOctetBin)+".255"
    elif gsm > 24:
      
        broadID=str(fOctet)+"."+str(sOctet)
        broadID+="."+str(tOctet)
        foOctetBin =""
        bin = convertToBinary(foOctet)
        for i in range(8):
           # print (splitMask[3])
            if(splitMask[3][i]) == "1":
                foOctetBin+="0"
            else:
                foOctetBin+=str(bin)[i]
        #foOctetBin = convertToDecimal(foOctetBin)

        broadID+="."+wCLast
    
##Computes the broadcast ID if class is B
elif ipClass == "B":
    if gsm > 16 and gsm < 24:
        broadID=str(fOctet)+"."+str(sOctet)
        bin = convertToBinary(tOctet)
        tOctetBin = ""
        for i in range(8):
            if (splitMask[2][i]) == "0":
                tOctetBin+="1"
            else:
                tOctetBin+=str(bin)[i]
        tOctetBin = convertToDecimal(tOctetBin)
        broadID += "."+str(tOctetBin)+".255"

    elif gsm > 24:
        broadID=str(fOctet)+"."+str(sOctet)
        broadID+="."+str(tOctet)
        foOctetBin =""
        bin = convertToBinary(foOctet)
        for i in range(8):
            if(splitMask[3][i]) != "1":
                foOctetBin+="1"
            else:
                foOctetBin+=str(bin)[i]
 
        broadID+="."+str(convertToDecimal(foOctetBin))

##Computes the broadcast ID if class is C
elif ipClass == "C":
    if gsm > 16 and gsm < 24:
        broadID=str(fOctet)+"."+str(sOctet)
        bin = convertToBinary(tOctet)
        tOctetBin = ""
        for i in range(8):
            if (splitMask[2][i]) == "0":
                tOctetBin+="1"
            else:
                tOctetBin+=str(bin)[i]
        tOctetBin = convertToDecimal(tOctetBin)
        broadID += "."+str(tOctetBin)+".255"

    elif gsm > 24:
        broadID=str(fOctet)+"."+str(sOctet)
        broadID+="."+str(tOctet)
        foOctetBin =""
        bin = convertToBinary(foOctet)
        for i in range(8):
            if(splitMask[3][i]) != "1":
                foOctetBin+="1"
            else:
                foOctetBin+=str(bin)[i]
 
        broadID+="."+str(convertToDecimal(foOctetBin))

##Splitting the Broadcast ID
splitBroad = broadID.split(".")
splitBroad[3] = int(splitBroad[3])-1
subNetSplit[3] = int(subNetSplit[3])+1

##Setting up host max and min
if ipClass == "C" or ipClass =="A" or ipClass =="B":
    hostMax = str(splitBroad[0])+"."+str(splitBroad[1])+"."+str(splitBroad[2])+"."+str(splitBroad[3])
    hostMin = str(subNetSplit[0])+"."+str(subNetSplit[1])+"."+str(subNetSplit[2])+"."+str(subNetSplit[3])

splitMax = hostMax.split(".")
splitMin = hostMin.split(".")


##Getting subnet index
binaryIp=(convertToBinary(fOctet))+(convertToBinary(sOctet))+(convertToBinary(tOctet))+(convertToBinary(foOctet))
subnetIndex = (binaryIp[dsm:gsm])
subnetIndexDec = convertToDecimal(subnetIndex)





##Output sections
print ("Output:")
##Outputing the address in decimal and binary
print (("Address: "+(ipSplit[0])+"{:<27}"
+(convertToBinary(fOctet))+"."+(convertToBinary(sOctet))+"."+(convertToBinary(tOctet))+"."+(convertToBinary(foOctet))).format(""))

##Printing netmask information
print (("Netmask: "+str(convertToDecimal(splitMask[0]))+"."+str(convertToDecimal(splitMask[1]))+"."+str(convertToDecimal(splitMask[2]))
+"."+str(convertToDecimal(splitMask[3]))+" = "+str(gsm)+"{:<20}"+ netMask).format(""))

##Printing wildcard information
print (("Wildcard: "+str(255-(convertToDecimal(splitMask[0])))+"."+str(255-convertToDecimal(splitMask[1]))+"."+str(255-convertToDecimal(splitMask[2]))
+"."+str(255-convertToDecimal(splitMask[3]))+"{:<26}" + wC).format(""))

##Outputting the subnet ID
print ("=>")
print (("Subnet (Network): "+subNetId+"/"+str(gsm) +"{:<15}"+convertToBinary(int(subNetSplit[0]))+"."+convertToBinary(int(subNetSplit[1]))+"."+convertToBinary(int(subNetSplit[2]))+"."
+convertToBinary(int(subNetSplit[3]))).format(""))


print (("Broadcast Address: "+broadID+"{:<15}"+str(convertToBinary(int(splitBroad[0]))+".")+str(convertToBinary(int(splitBroad[1]))+".")
 +str(convertToBinary(int(splitBroad[2]))+".")+str(convertToBinary(int(splitBroad[3])))).format(""))

print(("Host Min: "+hostMin+"{:<26}"+str(convertToBinary(int(splitMin[0]))+".")+str(convertToBinary(int(splitMin[1]))+".")+str(convertToBinary(int(splitMin[2]))+".")
+str(convertToBinary(int(splitMin[3])))).format(""))

print("Host Max: "+hostMax+"                        "+str(convertToBinary(int(splitMax[0]))+".")+str(convertToBinary(int(splitMax[1]))+".")+str(convertToBinary(int(splitMax[2]))+".")
+str(convertToBinary(int(splitMax[3]))))

print ("s = "+str(s))
print ("S = "+str(S))
print ("Subet Index ("+subnetIndex+") = "+str(subnetIndexDec))
print ("h = "+str(h))
print ("HIPs Hosts/Net: "+str(uH))





