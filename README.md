```
Camera2 ——> new CameraUse()..

Camera2 + textureView 预览 拍照

opengles + Camera2 预览 拍照
```

四分屏

![Image text](https://github.com/ABCDQ123/opengltest/blob/main/lib_camera/image/split.gif)

分色偏差

![Image text](https://github.com/ABCDQ123/opengltest/blob/main/lib_camera/image/offset.gif)

加权混合

![Image text](https://github.com/ABCDQ123/opengltest/blob/main/lib_camera/image/mix.gif)

区域绘制

![Image text](https://github.com/ABCDQ123/opengltest/blob/main/lib_camera/image/circle.gif)

#### ?????????????奇怪的小知识?????????????

#### 纹理存取

```
YUV 常用存储
glTexImage2D(GL_TEXTURE_2D, 0, GL_LUMINANCE, w, h, 0, GL_LUMINANCE, GL_UNSIGNED_BYTE, 0); 
glTexImage2D(GL_TEXTURE_2D, 0, GL_LUMINANCE_ALPHA, w, h, 0, GL_LUMINANCE_ALPHA, GL_UNSIGNED_BYTE, 0);
RBGA 常用存储
glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, w, h, 0, GL_LUMINANCE, GL_UNSIGNED_BYTE, 0);
glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, w, h, 0, GL_LUMINANCE, GL_UNSIGNED_BYTE, 0);

对应存取格式
(L 亮度 ， R 红色 ， G 绿色 ， B 蓝色 ， A 透明度) (r,g,b,a)/(x,y,z,w)
GL_LUMINANCE        -> vec4(L,L,L,1)  -> L即Y或U或V (例YUV420888) -> texture(Map, Coord).r/texture(Map, Coord).g/texture(Map, Coord).b
GL_LUMINANCE_ALPHA  -> vec4(L,L,L,A)  -> L即Y A即U或V (例NV21)    -> texture(Map, Coord).r 为 Y + texture(Map, Coord).a 为 V/U
GL_RGB              -> vec4(R,G,B,1)  -> R,G,B                   -> .r .g .b .a
GL_RGBA             -> vec4(R,G,B,A)  -> R,G,B,A                 -> .r .g .b .a
```

