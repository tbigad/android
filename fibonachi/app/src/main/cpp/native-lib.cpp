#include <jni.h>
#include <string>
#include <cstdlib>
#include <sstream>

int fib(int n)
{
    if (n < 2) return n;
    return fib(n - 1) + fib(n - 2);
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_paveln_fibonachi_MainActivity_stringFibonachiFromJNI(JNIEnv *env, jobject instance,
                                                                      jstring number_) {
    const char *number = env->GetStringUTFChars(number_, 0);

    // TODO
    int i = fib(std::atoi(number));
    std::ostringstream os ;
    os << i;

    env->ReleaseStringUTFChars(number_, number);

    return env->NewStringUTF(os.str().c_str());
}