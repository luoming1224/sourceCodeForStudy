#ifndef __GEO_H__
#define __GEO_H__

#include "server.h"

/* Structures used inside geo.c in order to represent points and array of
 * points on the earth. */
typedef struct geoPoint {
    double longitude;   //经度
    double latitude;    //纬度
    double dist;
    double score;
    char *member;
} geoPoint;

// 用于储存多个地理位置的数组
typedef struct geoArray {
    struct geoPoint *array;
    size_t buckets;     //数组预分配的大小
    size_t used;        //数组目前已用的项数量
} geoArray;

#endif
