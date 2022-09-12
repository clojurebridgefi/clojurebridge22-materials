This installation guide helps you to install required software for ClojureBridge.
First it guides you to install required Java SDK version, and Visual Studio Code, then set up the development environment. There are separate parts for installing the software for Mac and Windows.

# A.Install required software

# Mac OS

1. Insert USB stick
2. Copy forMacs.zip somewhere on your laptop
3. Remove USB stick and give it to the next person
4. Unzip the zip by double-clicking it

## Install Java

1. Open Spotlight (command + space), search for Terminal and open it
2. Write `java -version` command and press enter. If you see ` version "1.8.0_xxxx"`, you should be okay and you can continue to next section, installing Visual Studio Code. Otherwise continue to **3**.
3. Find the folder you unzipped, and doubleclick the "jdk-8u341-macosx-x64.dmg" -file.
4. Doubleclick on "JDK 8 Update 341.pkg", and continue the installation per instructions.

## Install Visual Studio Code

1. Open the vscode-folder and click the Visual Studio Code.app. If the computer asks for access rights, say it's okay to open.
2. If you get a popup warning that the application is downloaded from the Internet, confirm "Open".
3. Continue with **B. Set up VSCode**.

# Windows

1. Insert USB stick
2. Copy forWindows.zip somewhere on your laptop
3. Remove USB stick and give it to the next person
4. Unzip the zip by double-clicking it

## Install Java

1. Open Powershell (via Start-menu search)
2. Write `java -version` command and press enter. If you see ` version "1.8.0_xxx"`, you should be okay and you can continue to next section, installing Visual Studio Code. Otherwise continue to **3**.
3. Find the folder you unzipped, and doubleclick the "jdk-8u341-windows-x64.exe" -file and continue the installation per instruction.

## Install Visual Studio Code

1. Open the vscode-folder doubleclick Code.exe
2. If you get a security warning, click "Run"
3. Click "Install" and wait until Visual Studio Code opens
4. If you get a Windows Defender/Firewall warning, click "Allow"
5. Continue with **B. Set up VSCode**.

If you are using Linux, you can ask help from the coach.

# B. Set up VSCode

## Get the materials

1. Go to `https://github.com/clojurebridgefi/clojurebridge22-materials`, and click the green button saying "Code". Select "Download ZIP".
2. Unzip the clojurebridge22-materials.zip
3. In Visual Studio Code, select File -> Open folder. Find the materials you just unzipped and select the "clojurebridge22-materials-main"-folder.
4. VSCode might ask for a permission to access the folder.
5. You might see a notification about whether you trust the authors of the files. Say you trust them, it's us :)

## Open the first file and start the REPL!

6. On the left you will see a project called clojurebridge. Click it open, then select src → clojurebridge → basics.clj
7. Start the repl with two key combinations: Ctrl + Option + c and then Ctrl + Option + j.
8. If you're prompted to select from two projects, select the one that ends with clojurebridge.
9. From the project type selection pick Leiningen, and then for the profiles to lauch with, just click Ok (no überjar).
10. You should see the repl on the right side, telling "Jack-in done". If not, ask for help from a coach.
