package service.bind.test.draglayout

import android.content.Context
import android.graphics.*

/**
 * Author:  LiuHao
 * Email:   114650501@qq.com
 * TIME:    6/30/21 --> 10:32 PM
 * Description: This is DrawBitmap
 */

/**
 * 获取bitmap
 */
fun getBitmap(context: Context, resId: Int): Bitmap {
    return BitmapFactory.decodeResource(context.resources, resId)
}

fun drawBitmap(canvas: Canvas, bitmap: Bitmap, width: Int, height: Int) {
    // 画出原图像
    modifyBitmapSize(bitmap, width, height)?.let { canvas.drawBitmap(it, 0f, 0f, null) }
}

fun modifyBitmapSize(map: Bitmap, width: Int, height: Int): Bitmap? {
    val bmpSize = intArrayOf(map.width, map.height) //获得待修改图像的长、宽
    val matrix = Matrix() //创建变化矩阵
    matrix.postScale(width.toFloat() / bmpSize[0], height.toFloat() / bmpSize[1])
    return Bitmap.createBitmap(map, 0, 0, bmpSize[0], bmpSize[1], matrix, true) //生成新的图像
}

/**
 * 绘制四个item
 */
fun drawItemBitmap(canvas: Canvas, bitmap: Bitmap, width: Int, height: Int, posX: Float, poxY: Float) {
    // 画出原图像
    modifyBitmapSizeItem(bitmap, width, height)?.let { canvas.drawBitmap(it, posX, poxY, null) }
}

fun modifyBitmapSizeItem(map: Bitmap, width: Int, height: Int): Bitmap? {
    val bmpSize = intArrayOf(map.width, map.height) //获得待修改图像的长、宽
    val matrix = Matrix() //创建变化矩阵
    matrix.postScale(width.toFloat() / 3 / bmpSize[0], height.toFloat() / 3 / bmpSize[1])
    return Bitmap.createBitmap(map, 0, 0, bmpSize[0], bmpSize[1], matrix, true) //生成新的图像
}