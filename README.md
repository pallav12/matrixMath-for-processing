## How to install MatrixMath

You can install Rainbow eiteher from contribution manager or install it manually

for detail's check [How to install contributed library](https://github.com/processing/processing/wiki/How-to-Install-a-Contributed-Library)

### How to use
import Rainbow either from contribution mangager or manual installation
if you are able to write 
~~~
import Rainbow.*;
~~~
without any error then you are good to go.

Next initialize any Rainbow class in setup(), pass PApplet (this) as arument in constructor.
For MengerSponge
~~~
MengerSponge mengerSponge;
void setup(){
  size(600,600,P3D);
  mengerSponge=new MengerSponge(this);
}
~~~
Now to run the actual MengerSponge Animation
~~~
void draw(){
  mengerSponge.draw(); 
}
~~~
Output

<img src="https://i.ibb.co/ZL3DKKJ/Screenshot-103.png" width="300dp" height="300dp"/>

You'll notice you still can't click on cube that's because
If the animation involves any events like mouseClicked(), MousePressed() etc you have to add corresponding events.

~~~
void mousePressed(){
  mengerSponge.mousePressed();
}
~~~
that's it.

<img src="https://i.ibb.co/tYHngNN/Screenshot-edited-104.png" width ="300dp" height="300dp"/>


### Troubleshooting

If you're having trouble, have a look at the [Processing Wiki](https://github.com/processing/processing/wiki/How-to-Install-a-Contributed-Library) for more information, or contact the author [Pallav Dubey](https://github.com/pallav12/).
