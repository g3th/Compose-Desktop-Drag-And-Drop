# Compose Desktop - Drag And Drop Example
## Drag And Drop Example in Compose for Desktop


Since some features are missing or currently not supported for Desktop, implementing Drag-And-Drop operations results in more convoluted code than in Android, for instance. The absence of "Modifier.dragAndDropTarget" or "View.OnDragListener" for Desktop makes matters more complicated as implementing a target listener takes more lines of code.


This is an example of how to implement a Drag-and-Drop operation using ```pointerInput```, ```detectDragGestures``` and ```CompositionLocalOf``` to pass data, such as current Offsets or Booleans, between composable functions. Although there are probably other ways of implementing such an operation, I have found this was the easiest and most popular


The app also implements:


- ```Modifier.clip``` in order to draw a custom shape using ```PathParser()``` to parse an svg path as a String, originally obtained by using InkScape in Linux.

- ```Modifier.clickable``` so that the custom shape is clickable

- ```Brush.lineargradient``` to generate a gradient once the animal shape is clicked. A function generates random colors each time the shape is clicked. 


Additional functionality will probably be added in the future, such as more shapes, but this example serves mainly as a reference.


Build with IntelliJ or Android Studio.
