# NebulaPainter
Random image generation software that creates unique pixelated images with varrying levels of complexity.

Jack St. Hilaire - 2020

-------------------------------------------------------------

To run this program from a command line:

java -jar NebulaPainter.jar

-------------------------------------------------------------

This program has three main functions: collecting user input for different settings, 
generating a random image, and saving the image and settings to .png and .txt files.

The settings control different aspects of the image generation process, which has 3 steps.

1. A base layer of random colored pixels is applied to the image

2. A filter layer, default black (night skies), that covers the canvas with one color (optional)

3. Optional rectangle and line layers that select random areas of the image, and update pixels

You can also specify 'random color ranges', which essentially limit the RGB values that can be
selected at random. This can drasitcally change what generated pictures look like. 

-------------------------------------------------------------

Messing around with the settings produces interesting complexity and unique imagery, 
but even the default settings can produce fascinating randomly generated pictures!
