# dots_binary_NN_classificator
### $${\color{red}THE \space\space APP \space\space IS \space\space ACTIVELY \space\space IMPROVED}$$
## About
*Dots binary NN classificator* is a platform for practical training of students in neural networks.

The platform is Java client-server application for binary classification of points. Points are entered by the user using the mouse by click the left or right keys. 
The server stores user neural network information in an SQL database. 

Neural network parameters are set in the start window on the client side:
+ learning rate
+ hidden layers
+ number of epochs

## Interface
Client start window:

<img src="https://user-images.githubusercontent.com/78417431/222393159-6d5e902a-af2d-4c23-b026-e1003489b88c.png" width="550">

Example:

![java_nn](https://user-images.githubusercontent.com/78417431/216107213-7bf569b7-f16e-442a-8d85-571397fe1f3d.gif)


## Diagram

<img src="https://user-images.githubusercontent.com/78417431/219960592-2774aa2e-51ae-4b18-ba25-234db96df195.png" width="900">

## Problem examples
+ Not enough hidden layers:

![нелинейное (online-video-cutter com)](https://user-images.githubusercontent.com/78417431/222389377-19953cd5-d4d7-4d91-b469-5d41ee58e009.gif)<img src="https://user-images.githubusercontent.com/78417431/222392650-87b0403d-f917-4516-a8a7-6026e787a1a4.png" width="550">

+ Excessive learning rate:

![слишком большой lr (2)](https://user-images.githubusercontent.com/78417431/222390100-ef90e8e0-d8e9-42f2-9e62-8acb208c2a03.gif)<img src="https://user-images.githubusercontent.com/78417431/222392080-f248cf0a-2542-43b0-904d-105db7827534.png" width="550">

+ Not enough epochs:

![последовательные шахматы маленькое количество эпох (online-video-cutter com)](https://user-images.githubusercontent.com/78417431/222391569-94975a89-ab8a-4f9c-8520-873e71b3afff.gif)<img src="https://user-images.githubusercontent.com/78417431/222392359-f2d40bd6-ace5-4a76-be1a-5116f824dc53.png" width="550">
