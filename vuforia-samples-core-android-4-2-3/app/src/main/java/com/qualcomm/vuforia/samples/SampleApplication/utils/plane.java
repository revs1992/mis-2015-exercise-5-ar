package com.qualcomm.vuforia.samples.SampleApplication.utils;

import java.nio.Buffer;

public class plane extends MeshObject {

    private Buffer mVertBuff;
    private Buffer mTexCoordBuff;
    private Buffer mNormBuff;
    private Buffer mIndBuff;

    private int indicesNumber = 0;
    private int verticesNumber = 0;


    public plane()
    {
        setVerts();
        setTexCoords();
        setNorms();
        setIndices();
    }

    private void setVerts()
    {
        double[] Plane_VERTS = {-1.0, -1.0, 0.0,
                1.0, -1.0, 0.0,
                1.0,  1.0, 0.0,
                -1.0, 1.0, 0.0};
        mVertBuff = fillBuffer(Plane_VERTS);
        verticesNumber = Plane_VERTS.length / 3;
    }

    private void setTexCoords()
    {
        double[] Plane_TEX_COORDS = {0.0,  0.0,
                1.0,  0.0,
                1.0,  1.0,
                0.0,  1.0};
        mTexCoordBuff = fillBuffer(Plane_TEX_COORDS);

    }

    private void setNorms()
    {
        double[] Plane_NORMS = {0.0, 0.0, 1.0,
                0.0, 0.0, 1.0,
                0.0, 0.0, 1.0,
                0.0, 0.0, 1.0};
        mNormBuff = fillBuffer(Plane_NORMS);
    }

    private void setIndices()
    {
        short[] Plane_INDICES = {0, 1, 2, 2, 3, 0};
        mIndBuff = fillBuffer(Plane_INDICES);
        indicesNumber = Plane_INDICES.length;
    }







    @Override
    public Buffer getBuffer(BUFFER_TYPE bufferType) {
        Buffer result = null;
        switch (bufferType)
        {
            case BUFFER_TYPE_VERTEX:
                result = mVertBuff;
                break;
            case BUFFER_TYPE_TEXTURE_COORD:
                result = mTexCoordBuff;
                break;
            case BUFFER_TYPE_NORMALS:
                result = mNormBuff;
                break;
            case BUFFER_TYPE_INDICES:
                result = mIndBuff;
            default:
                break;

        }

        return result;
    }

    @Override
    public int getNumObjectVertex() {
        return verticesNumber;
    }

    @Override
    public int getNumObjectIndex() {
        return indicesNumber;
    }
}
