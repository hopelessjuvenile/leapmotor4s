import Minio from 'minio'

export function returnMinioClient(){
    const Minio = require('minio');
    return new Minio.Client({
        endPoint: '10.1.1.239',
        port: 9000,
        useSSL: false,
        accessKey: 'minioadmin',
        secretKey: 'minioadmin',
    })
}