## How to install MatrixMath

### Install with the Contribution Manager

Add contributed Libraries by selecting the menu item _Sketch_ → _Import Library..._ → _Add Library..._ This will open the Contribution Manager, where you can browse for MatrixMath, or any other Library you want to install.

Not all available Libraries have been converted to show up in this menu. If a Library isn't there, it will need to be installed manually by following the instructions below.

### Manual Install

Contributed Libraries may be downloaded separately and manually placed within the `libraries` folder of your Processing sketchbook. To find (and change) the Processing sketchbook location on your computer, open the Preferences window from the Processing application (PDE) and look for the "Sketchbook location" item at the top.

By default the following locations are used for your sketchbook folder: 
  * For Mac users, the sketchbook folder is located inside `~/Documents/Processing` 
  * For Windows users, the sketchbook folder is located inside `My Documents/Processing`

Download MatrixMath from https://github.com/pallav12/matrixMath-for-processing/releases/download/latest/MatrixMath.zip

Unzip and copy the contributed Library's folder into the `libraries` folder in the Processing sketchbook. You will need to create this `libraries` folder if it does not exist.

The folder structure for Library MatrixMath should be as follows:

```
Processing
  libraries
    MatrixMath
      examples
      library
        MatrixMath.jar
      reference
      src
```
             
Some folders like `examples` or `src` might be missing. After Library MatrixMath has been successfully installed, restart the Processing application.

### Examples
~~~
float[][] array1={{434,30},{1,5}};  //sample array
float[][] array2={{4,7},{2,6}};
float[][] add=Matrix.add(array1,array2);
float[][] transpose=Matrix.transpose(array1);
float determinant=Matrix.determinant(array1);
float[][] inverse=Matrix.inverse(array1);
float[][] newTranspose=Matrix.add(Matrix.transpose(array1),array2);


Matrix.print(array1);
Matrix.print(array2);
Matrix.print("Line 14: sum of array1 and array 2 is ",add);
Matrix.print("Line 15: array 1 is ", array1);
Matrix.print("Line 16: transpose of array1 is ",transpose);
println("Line 17: determinant of array 1 is " + determinant);
Matrix.print("Line 18: inverse of array 1 is ",inverse);
Matrix.print("Line 19: sum of transpose of array 1 and array 2 is ", newTranspose);
~~~
~~~
Matrix mat1=Matrix.array(array1);
Matrix mat2=Matrix.array(array2);
Matrix mat3=Matrix.add(mat1,mat2);
Matrix mat4=Matrix.transpose(mat1);
Matrix mat5=Matrix.Multiply(mat4,mat1);
Matrix mat6=Matrix.identity(4);
float[][] array=mat1.array;
float matDeterminant = Matrix.determinant(mat1);

Matrix.print(mat1);
Matrix.print(mat2);
Matrix.print("Line 33: mat1 is ", mat1);
Matrix.print("Line 34: transpose of mat1 is ",mat4);
Matrix.print("Line 35: inverse of mat1 is ",mat1);
Matrix.print("Line 36: sum of mat1 and mat2 is ",mat3);
Matrix.print("Line 37: sum of transpose of mat1 and mat2 is ", mat5);
println("Line 20: determinant of mat1 is " +matDeterminant);
Matrix.print("Identity matrix of size 4 is ", mat6);
Matrix.print(array);
~~~
### Troubleshooting

If you're having trouble, have a look at the [Processing Wiki](https://github.com/processing/processing/wiki/How-to-Install-a-Contributed-Library) for more information, or contact the author [Pallav Dubey](https://github.com/pallav12/).
