import request from '@/utils/request'

// 查询信息录入列表
export function listBaby(query) {
  return request({
    url: '/system/baby/list',
    method: 'get',
    params: query
  })
}

// 查询信息录入详细
export function getBaby(id) {
  return request({
    url: '/system/baby/' + id,
    method: 'get'
  })
}

// 新增信息录入
export function addBaby(data) {
  return request({
    url: '/system/baby',
    method: 'post',
    data: data
  })
}

// 修改信息录入
export function updateBaby(data) {
  return request({
    url: '/system/baby',
    method: 'put',
    data: data
  })
}

// 删除信息录入
export function delBaby(id) {
  return request({
    url: '/system/baby/' + id,
    method: 'delete'
  })
}

// 导出信息录入
export function exportBaby(query) {
  return request({
    url: '/system/baby/export',
    method: 'get',
    params: query
  })
}