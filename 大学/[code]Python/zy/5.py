for x in range(1,33):
    for y in range(1,48):
        for z in range(1,96):
            if 6*x+4*y+z==200 and x+y+z==100:
                print("大马%d匹,中马%d匹,小马%d匹"%(x,y,z))
