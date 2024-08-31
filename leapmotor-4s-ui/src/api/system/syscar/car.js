import request from '@/utils/request'
import axios from 'axios'

// 查询图像列表
export function listCarImage(query) {
  return request({
    url: '/system/car/licensePlate',
    method: 'get',
    params: query
  })
}

// 查询汽车信息
export function carInfo(serviceId) {
  return request({
    url: '/system/car/',
    method: 'get',
    params: serviceId
  })
}

// 新增【请填写功能名称】
export function addCar(data) {
  return request({
    url: '/system/car',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateCar(data) {
  return request({
    url: '/system/car',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delCar(serviceId) {
  return request({
    url: '/system/car/' + serviceId,
    method: 'delete'
  })
}
