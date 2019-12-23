import pallav.Matrix.*;
//Demonstrating use of some of the static Methods of library


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
