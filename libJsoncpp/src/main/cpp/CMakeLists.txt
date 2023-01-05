# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.18.1)

project("jsoncpp-lib")

set(CMAKE_VERBOSE_MAKEFILE on)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
        jsoncpp

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        jsoncpp/json_reader.cpp
        jsoncpp/json_tool.h
        jsoncpp/json_value.cpp
        jsoncpp/json_valueiterator.inl
        jsoncpp/json_writer.cpp)

# 配置复制头文件及SO库
set(output_dir ${CMAKE_CURRENT_SOURCE_DIR}/../../../../output)

set_target_properties(
        jsoncpp
        PROPERTIES LIBRARY_OUTPUT_DIRECTORY "${output_dir}/jniLibs/${ANDROID_ABI}")

add_custom_command(
        TARGET jsoncpp POST_BUILD
        COMMAND "${CMAKE_COMMAND}" -E copy_directory "${CMAKE_CURRENT_SOURCE_DIR}/jsoncpp/json" "${output_dir}/jniInterface/json/")