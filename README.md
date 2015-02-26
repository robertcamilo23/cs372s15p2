# Project 2

## Line segments and their intersection behavior explanation ##

![intersectsExplanation.png](https://bitbucket.org/repo/5jya9G/images/2854514210-intersectsExplanation.png)

I have implemented the method intersectsLineSegment inside the class LineSegment. That means that this behavior it is going to be used by an instance of LineSegment and say if it intersects with another LineSegment that is taken as parameter. In the way how I have implemented a Ray (extends a LineSegment), it is enough and elegant to have the definition in LineSegment and lean on the inheritance. At the end of the day it's that you can handle several scenarios like compare:

*  LineSegment against LineSegment
*  LineSegment against Ray
*  Ray against LineSegment
*  Ray against Ray

In this method I have use pattern matching, check if line segments are parallel, or if the line it's vertical (slope is infinite), or just checking if the two lines intersects but within the range of the line segments.

## Group behaviors explanation ##

**getBoundingBoxTuple**

![boundingBoxTuple.png](https://bitbucket.org/repo/5jya9G/images/2040818482-boundingBoxTuple.png)

I'm calculating the bounding box in the Group class, but I'm not sending the bounding box itself but a tuple that contains the important information of the bounding box, that is: x and y starting point, x and y finish point, the area of the bounding box, and the rectangle of the bounding box.

## Polygon behaviors explanation ##

**getLineSegments**

I did the method getLineSegments that return a List[ LineSegment ]. I'm just taking the list of points that compose the Polygon, with the function *sliding( 2 ).toList* I obtain a List of pair of points, and then I just foldLeft that list to create a List of LineSegment using the list of pair of points.

**pointsInPolygon**

![pointsInPolygon.png](https://bitbucket.org/repo/5jya9G/images/800444218-pointsInPolygon.png)

The function pointsInPolygon  it's a tail recursive function that iterate over the bounding box of the polygon. I'm not shooting random rays but instead I'm shooting 121 (11*11) rays every square of 1 by 1. I'm shooting a ray from the initial point, and the final point is going to take the same y value as the initial point, and for the x it is going to take the x edge of the bounding box. Then I count the number of intersections that have that ray with the polygon with the function intersection, an then I just check if that number is odd or not.