#include <windows.h>
#include <GL/GLUT.H>
#define _CRT_SECURE_NO_DEPRECATE
#include <iostream>
#include <windows.h>
#include <stdio.h>
//using namespace std;
	
void bitmaptest(){
GLubyte buffer[20]={0x1c,0x00,0x1c,0x00,0x1c,0x00,0x1c,0x00,0x1c,0x00,0xff,0x80,0x7f,0x00,0x3e,0x00,0x1c,0x00,0x08,0x00};
GLubyte rasters[24] = {                                                //defining the bitmap in hexadecimal as discussed above
    0xc0, 0x00, 0xc0, 0x00, 0xc0, 0x00, 0xc0, 0x00, 
    0xc0, 0x00, 0xff, 0x00, 0xff, 0x00, 0xc0, 0x00, 
    0xc0, 0x00, 0xc0, 0x00, 0xff, 0xc0, 0xff, 0xc0};
glClear(GL_COLOR_BUFFER_BIT);
glPixelStorei(GL_UNPACK_ALIGNMENT,1);
    glColor3f(0, 0, 0);
    glRasterPos2i (20, 20);                             
    glBitmap(9, 10, 0.0, 0.0, 0, 0.0, buffer);     
    glFlush();
}


void draw() {
glClear(GL_COLOR_BUFFER_BIT);
glColor3ub(150,150,150);


}



int main(int argc, char **argv) {

	// init GLUT and create Window
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGBA);
	glutInitWindowPosition(100,100);
	glutInitWindowSize(800,600);
	glutCreateWindow("HaMiD");
	//range zamine
	glClearColor(1,1,1,1);
	gluOrtho2D(-400,400,-300,300);
	//gluOrtho2D(-4,4,-3,3); baraye bakhshe sahmi 
	glutDisplayFunc(draw);
	glutMainLoop();
	
	return 1;
}