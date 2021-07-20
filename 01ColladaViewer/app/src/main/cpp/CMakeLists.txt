cmake_minimum_required(VERSION 3.10.2)
project(dragon)

set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Wall")
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11 -Wall")


#set up a core library which is shared between the animation-lib and the app-lib
add_library(core SHARED core/Vector.cpp core/Camera.cpp core/ModelMatrix.cpp core/Texture.cpp core/Shader.cpp)
target_include_directories(core PRIVATE core/Vector.h core/Camera.h core/ModelMatrix.h core/Texture.h  core/Shader.h)
target_link_libraries(core GLESv3 android stb_image  tiny log)

#set up the app library
add_library(dragon SHARED Native.cpp MeshCube.cpp DeltaClock.cpp)
target_include_directories(dragon PRIVATE MeshCube.h DeltaClock.h)
target_link_libraries(dragon animation)



#add some helper libraries
add_subdirectory(TinyXml)
add_subdirectory(stb)
add_subdirectory(animation)





