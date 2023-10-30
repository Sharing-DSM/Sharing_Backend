package com.example.sharing.global.utils.openfeign.client

import com.example.sharing.global.utils.openfeign.client.dto.response.SearchAddressResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@FeignClient(name = "KakaoFeign", url = "https://dapi.kakao.com")
interface KakaoAddressFeign {
    @GetMapping("/v2/local/search/address.json")
    fun queryAddress(@RequestParam("query") address: String, @RequestParam("page") page: Int?, @RequestParam("size") size: Int?): SearchAddressResponse
}