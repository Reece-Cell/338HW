import math
import random
import matplotlib.pyplot as plt
def FirstTest(x):
    return math.sin(x)
def SecondTest(x):
    return 1.0/3.0*x**3
def ThirdTest(x):
    return 1 + math.sin(x)
def integrate(f, a, b, n ):
    trapezoid = f(a)+f(b)
    dx = (b-a)/(n)
    for i in range(1,n):
        x = a + i*dx
        trapezoid = trapezoid + 2*f(x)
    trapezoid = trapezoid*dx/2.0
    return trapezoid
def random3xsq():
        seed = random.random()
        mth = seed**(1/3)
        return mth

def hist(ax, values, x_label, title='', y_label='',
         density=False, bin_w=0, bin_start=0.0):
    m=max(values)
    if (bin_w == 0 ):
        h = [0]*(m+1)
        for x in values:
            h[x]+=1
    else :
        nbins = int((m-bin_start)/bin_w + 1)
        h = [0]*nbins
        x_axis = [0]*nbins
        for i in range(nbins):
            x_axis[i]=bin_start + bin_w*i
        for x in values:
            ibin = int((x - bin_start)/bin_w)
            h[ibin]+=1
    if (density):
        for i in range(len(h)):
            h[i]=h[i]/len(values)
    if (bin_w == 0):
        ax.bar( range(m+1), h, width=1, align='center')
    else:
        ax.bar(x_axis, h, width=bin_w, align='edge')
    ax.set_xlabel(x_label)
    ax.set_ylabel(y_label)
    if len(title) > 0:
        ax.set_title(title)

def valapprox(f, a, b, correct):
    #Dr Wisneski Provided code
    n=1
    ans=0.0
    while (abs(ans-correct) > .01):
        n=n*2
        ans=integrate(f, a, b, n)
        print('n = %d ans = %.3f'%(n,ans))
    #########################
print("Test 1 f(x)=sin(x), 0, pi"), valapprox(FirstTest, 0, math.pi, 2.0)
print("Test 2 f(x)=1/3*x**3, from 1 to 4"), valapprox(SecondTest, 1, 4, 21.25 )
print("Test 3 f(x)=sin(x)+1, from 0 to 2pi"), valapprox(ThirdTest, 0, 2.0*math.pi, 2.0*math.pi)
list=[]
for i in range(1000000):
        list.append(random3xsq())
fig, ax = plt.subplots()
hist(ax, list, 'x',
     title="Random Value Distribution with pdf(x)=3x**2",
     y_label="Probability",
     density=True,
     bin_w=.01,
     bin_start=0)
plt.show()
