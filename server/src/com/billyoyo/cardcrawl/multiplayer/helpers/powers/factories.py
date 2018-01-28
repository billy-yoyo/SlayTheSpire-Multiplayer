import os

for file in os.listdir("./"):
    if file.endswith(".java"):
        print("new " + file[:-5] + "().register();")