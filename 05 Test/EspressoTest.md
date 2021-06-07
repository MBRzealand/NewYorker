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
    <td>          textview_price_main_activity displays: "6272,22"  </td>
    <td>          textview_price_main_activity displays: "6272,22"  </td>
    <td>          　✓                                               </td>
  </tr>
  <tr>
    <td>          Test_02 </td>
    <td>          Test Minimum value </td>
    <td>          1. Input wall height </br>
                  2. Input wall width </td>
    <td>          Height = 10.8
                  Width = 10.8                                      </td>
    <td>          textview_price_main_activity
                  displays: "842,55"                                </td>
    <td>          textview_price_main_activity displays: "842,55"   </td>
    <td>          　✓                                               </td>
  </tr>
  <tr>
    <td>          Test_03                                           </td>
    <td>          Test Maximum value </td>
    <td>          1. Input wall height </br>
                  2. Input wall width </td>
    <td>          Height = 250
                  Width = 100                                       </td>
    <td>          textview_price_main_activity
                  displays: "9920,37"                               </td>
    <td>          textview_price_main_activity 
                  displays: "9920,37"                               </td>
    <td>          　✓                                               </td>
  </tr>
  <tr>
    <td>          Test_04 </td>
    <td>          Height too small exception                        </td>
    <td>          1. Input wall height                              </td>
    <td>          Height = 10.7                                     </td>
    <td>          Displays: 
                  "Højden er for lille, min: 10.8 max: 250"         </td>
    <td>          Displays: 
                  "Højden er for lille, min: 10.8 max: 250"         </td>
    <td>          　✓                                               </td>
  </tr>
    <tr>
    <td>          Test_05 </td>
    <td>          Width too small exception                         </td>
    <td>          1. Input wall width                               </td>
    <td>          Width  = 10.7                                     </td>
    <td>          Displays: 
                  "Bredden er for lille, min: 10.8"                 </td>
    <td>          Displays: 
                  "Bredden er for lille, min: 10.8"                 </td>
    <td>          　✓                                               </td>
  </tr>
  <tr>
    <td>          Test_06 </td>
    <td>          Height too large exception                        </td>
    <td>          1. Input wall height                              </td>
    <td>          Height = 250.1                                    </td>
    <td>          Displays: 
                  "Højden er for stor, min: 10.8 max: 250"          </td>
    <td>          Displays: 
                  "Højden er for stor, min: 10.8 max: 250"          </td>
    <td>          　✓                                               </td>
  </tr>
  <tr>
    <td>          Test_07 </td>
    <td>          Missing height exception                          </td>
    <td>          1. Input wall height                              </td>
    <td>          Height =                                          </td>
    <td>          Displays:
                  "Mangler højde"                                   </td>
    <td>          Displays: 
                  "Mangler højde"                                   </td>
    <td>          　✓                                               </td>
  </tr>
  <tr>
    <td>          Test_08 </td>
    <td>          Missing width exception                           </td>
    <td>          1. Input wall width                               </td>
    <td>          Width =                                           </td>
    <td>          Displays:
                  "Mangler bredde"                                  </td>
    <td>          Displays: 
                  "Mangler bredde"                                  </td>
    <td>          　✓                                               </td>
  </tr>
</table>
