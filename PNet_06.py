import random
import datetime

dIn = open(r"C:\Users\User\OneDrive\IDE\PyCharm\pibiti\petri net\in.txt", "r+") #Windos
dOutcsv = open(r"C:\Users\User\OneDrive\IDE\PyCharm\pibiti\petri net\out.csv", "w+") #Windos
dOuttxt = open(r"C:\Users\User\OneDrive\IDE\PyCharm\pibiti\petri net\out.txt", "w+") #Windos

####### Read's House  #######

number = int(dIn.readline().split(' ')[1])  # numeros de processos

####### Function's House  #######

def randomMat(t):
    l = []
    for i in range(t):
        c = []
        for j in range(t):
            c.append(random.randint(0,1))
        l.append(c)
    return l
def randomVet(t):
    v = []
    for i in range(t):
        v.append(random.randint(0,1))
    return v

# maior valor de um vetor
def maiValVet(v):
    x = v[0]
    I = 0
    for i in range(len(v)):
        if x <= v[i]:
            x = v[i]
            I = i
    return [x,I+1]

# torna qualquer numero binario
def bin(n):
    if n != 0:
        return 1

# menor valor superior e diferente de zero
def menValdifZer(n):
    v, I = n[0], 0
    if v == 0:
        for j in range(len(n)):
            if n[j] != 0 and n[j] > 0:
                v = n[j]
                I = j
    for i in range(len(n)):
        if n[i] < v and n[i] != 0 and n[i] > 0:
            v = n[i]
            I = i
    return [v, I]

#multiplica matrizes por um vetor
def multVetMat(v, m):
    if len(v) != len(m):
        return "ERROR: Tamanho do Vetor ou Matriz incopativeis"
    else:
        r = []
        for i in range(len(m[0])):
            q = 0
            for j in range(len(v)):
                q += m[j][i]*v[j]
            r.append(q)
        return r

#compara duas matrizes de tamanhos iguais
def compMat(m,n):
    try:
        b = 0
        for i in range(len(m)):
            if m[i] >= n[i]:
                b += 0
            else:
                b += 1
        if b == 0:
            return True
        else:
            return False
    except:
        return "ERROR: Tamanho incompativel entre as matrizes"

#soma dois vetores de tamanhos iguais
def somVet(m,n):
    if len(m) != len(n):
        return "ERROR: Tamnhos incompativeis"
    else:
        z = []
        for i in range(len(m)):
            z.append(m[i]+n[i])
        return z

#diminui duas matrized de tamanhos iguais
def dimMat(D,d):
    if len(D) != len(d):
        return "ERROR: Tamnhos incompativeis"
    else:
        z = []
        for i in range(len(D)):
            m = []
            for j in range(len(D[0])):
                m.append(D[i][j]-d[i][j])
            z.append(m)
        return z

#operacao
def mL(n,m,dm,dp):
    if compMat(m,multVetMat(n,dm)):
        return somVet(multVetMat(n,dimMat(dp,dm)),m)
    else:
        return False


# menor valor de um vetor
def menValVet(v):
    x = v[0]
    I = 0
    for i in range(len(v)):
        if x >= v[i]:
            x = v[i]
            I = i
    return [x,I]

#toda vez em que verificar qual o menor tempo, cria um vet para que inicia o t correspondente [10,5,2] = [0,0,1]
def newVetChama(n):
    G = []
    for i in range(len(n)): # n sao e o vetor com as chamadas [10,5,2]
        if i == menValVet(n)[1]:
            G.append(1)
        else:
            G.append(0)
    return G

def a(n):
    x = 0
    for i in range(len(n)):
        if n[i] != 0:
            x = i
    return x

# aplicacao
def app(times):
    for k in range(times):
        Cc = datetime.datetime.today()  # relogio global
        rs = dIn.readline()
        r = int(dIn.readline().split(' ')[1])  # vezes que o processo oorre
        dpi = (dIn.readline().split(' ')[1]).split(';')
        dp = []  # matrix +
        for j in dpi:
            z = []
            for i in j.split(','):
                z.append(int(i))
            dp.append(z)
        dmi = (dIn.readline().split(' ')[1]).split(';')
        dm = []  # matrix -
        for j in dmi:
            z = []
            for i in j.split(','):
                z.append(int(i))
            dm.append(z)
        mi = (dIn.readline().split(' ')[1]).split(',')
        m = []  # vetor inicial
        for i in mi: m.append(int(i))
        ni = (dIn.readline().split(' ')[1]).split(';')
        K = []
        for i in ni:
            q = []
            for j in i.split(','):
                q.append(int(j))
            K.append(q)
        n = []  # vetor de comando com os tempos em um determinado range aleatorio
        for i in range(len(K)): n.append(random.randint(K[i][0], K[i][1]))
        N = []  # Nessa nova forma podemos colocar o tempo no vetor que o programa troca por 1 e 0
        for i in n:
            if i != 0:
                N.append(1)
            else:
                N.append(0)
        q = n
        alo = (f"ID: {str(k + 1)}")
        print(alo)
        dOuttxt.write(alo + '\r')
        for i in range(r):
            g = newVetChama(n)
            M = mL(g, m, dm, dp)
            if M != False:
                pt = (f"r: {str(i + 1)}; u: {str(m)}; n: {str(n)}; u': {str(M)}; time: {str(Cc)}")
                print(pt)
                dOutcsv.write(str(k + 1) + ';' + str(n) + ';' + str(M) + '\r')
                dOuttxt.write(pt + '\r')
                m = M
                N = []
                r = a(g)
                for i in range(len(n)):
                    if i == a(g):
                        N.append(q[i])
                        Cc += datetime.timedelta(minutes=q[i])
                    else:
                        if n[i] - n[r] == 0:
                            N.append(n[i])
                        else:
                            N.append(n[i] - n[r])
                n = N
            else:
                tp = (f'r: {str(i + 1)} -- ERROR!! -- {str(n)}')
                print(tp)
                dOuttxt.write(tp + '\r')
                n = []  # vetor de comando com os tempos em um determinado range aleatorio
                for i in range(len(K)): n.append(random.randint(K[i][0], K[i][1]))
        timeGlobal = (f'Relogio Global: {str(Cc)}')
        dOuttxt.write(timeGlobal + '\r')
        print(timeGlobal)

        #else:
            #caso nao tenha moedas para executar o processo oq acontece? i dont know


####### Call's House  #######

app(number)

####### Closing Files  #######

dIn.close()
dOutcsv.close()
dOuttxt.close()