<table style="width:100%">
  <tr>  
    <th>          Test Case 　  　ID　　　                           </th>
    <th>          Test Case Objective                               </th>
    <th>     　　　Steps　　　　　　                                  </th>
    <th>          Input Data　　　　                                 </th>
    <th>          Expected Output                                   </th>
    <th>          Actual Output                                     </th>
    <th>          Status                                            </th>
  </tr>
  <tr>
    <td>          Test_01                                           </td>
    <td>          Calculate standard wall price                     </td>
    <td>          1. Input wall height                              <br>
                  2. Input wall width                               </td>
    <td>          Height = 150                                      <br>
                  Width = 100                                       </td>
    <td>          6272,22                                           </td>
    <td>          6272,22                                           </td>
    <td>          　✓                                               </td>
  </tr>
  <tr>
    <td>          Test_02                                           </td>
    <td>          Test Minimum value                                </td>
    <td>          1. Input wall height                              <br>
                  2. Input wall width                               </td>
    <td>          Height = 10.8                                     <br>
                  Width = 10.8                                      </td>
    <td>          842,55                                            </td>
    <td>          842,55                                            </td>
    <td>          　✓                                               </td>
  </tr>
  <tr>
    <td>          Test_03                                           </td>
    <td>          Test Maximum value                                </td>
    <td>          1. Input wall height                              <br>
                  2. Input wall width                               </td>
    <td>          Height = 250                                      <br>
                  Width = 100                                       </td>
    <td>          9920,37                                           </td>
    <td>          9920,37                                           </td>
    <td>          　✓                                               </td>
  </tr>
  <tr>
    <td>          Test_04                                           </td>
    <td>          Height too small exception                        </td>
    <td>          1. Input wall height                              </td>
    <td>          Height = 10.7                                     </td>
    <td>          Højden er for lille, min: 10.8 max: 250           </td>
    <td>          Højden er for lille, min: 10.8 max: 250           </td>
    <td>          　✓                                               </td>
  </tr>
  <tr>
    <td>          Test_05                                           </td>
    <td>          Width too small exception                         </td>
    <td>          1. Input wall width                               </td>
    <td>          Width  = 10.7                                     </td>
    <td>          Bredden er for lille, min: 10.8                   </td>
    <td>          Bredden er for lille, min: 10.8                   </td>
    <td>          　✓                                               </td>
  </tr>
  <tr>
    <td>          Test_06                                           </td>
    <td>          Height too large exception                        </td>
    <td>          1. Input wall height                              </td>
    <td>          Height = 250.1                                    </td>
    <td>          Højden er for stor, min: 10.8 max: 250            </td>
    <td>          Højden er for stor, min: 10.8 max: 250            </td>
    <td>          　✓                                               </td>
  </tr>
  <tr>
    <td>          Test_07                                           </td>
    <td>          Missing height exception                          </td>
    <td>          1. Input wall height                              </td>
    <td>          Height =                                          </td>
    <td>          Mangler højde                                     </td>
    <td>          Mangler højde                                     </td>
    <td>          　✓                                               </td>
  </tr>
  <tr>
    <td>          Test_08                                           </td>
    <td>          Missing width exception                           </td>
    <td>          1. Input wall width                               </td>
    <td>          Width =                                           </td>
    <td>          Mangler bredde                                    </td>
    <td>          Mangler bredde                                    </td>
    <td>          　✓                                               </td>
  </tr>
